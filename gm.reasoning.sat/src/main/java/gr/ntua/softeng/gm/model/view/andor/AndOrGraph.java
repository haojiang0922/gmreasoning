package gr.ntua.softeng.gm.model.view.andor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.traverse.TopologicalOrderIterator;

import gr.ntua.softeng.gm.model.GoalModelAbstraction;

public class AndOrGraph extends DefaultDirectedGraph<AndOrGraphNode, AndOrGraphEdge> {

	private Map<String,AndOrGraphNode> nodesMap = new HashMap<>();
	
	public AndOrGraph(GoalModelAbstraction gm) {
		super(new ClassBasedEdgeFactory<AndOrGraphNode, AndOrGraphEdge>(AndOrGraphEdge.class));
		AndOrTree andOrTree  = new AndOrTree(gm);
		Map<String,AndOrRule> rulesMap = andOrTree.getRulesMap();
		this.parseRules(rulesMap);
		if (this.detectCycle()) throw new IllegalArgumentException("Cycles detected in the given Goal Tree!");
	}
	
	public List<AndOrRule> getSortedRulesList() {
		List<AndOrRule> list = new LinkedList<>();
		Iterator<AndOrGraphNode> iter = this.iterator();
		while (iter.hasNext()) {
			AndOrGraphNode andOrGraphNode = (AndOrGraphNode) iter.next();
			if (andOrGraphNode.getAndOrRule() != null) {
				list.add(andOrGraphNode.getAndOrRule());
			}
		}
		return list;
	}
	
	private boolean detectCycle() {
		CycleDetector<AndOrGraphNode, AndOrGraphEdge> detector = new CycleDetector<>(this);
		return detector.detectCycles();
	}
	
	private void parseRules(Map<String,AndOrRule> rulesMap) {
		for(Entry<String,AndOrRule> ruleEntry : rulesMap.entrySet()) {
			AndOrRule rule = ruleEntry.getValue();
			AndOrGraphNode parentNode = this.createOrUpdateNode(rule);
			Set<String> childNodeKeys = rule.getChildNodeKeys();
			Set<AndOrGraphNode> childNodes = this.createOrGetNodes(childNodeKeys);
			for (AndOrGraphNode child : childNodes) {
				this.addEdge(child, parentNode);
			}
		}
	}
	
	private Set<AndOrGraphNode> createOrGetNodes(Set<String> keys) {
		Set<AndOrGraphNode> nodes = new HashSet<AndOrGraphNode>();
		for (String k : keys) {
			nodes.add(this.createOrGetNode(k));
		}
		return nodes;
	}
	
	private AndOrGraphNode createOrUpdateNode(AndOrRule rule) {
		String nodeKey = rule.getParentNodeKey();
		AndOrGraphNode node = this.createOrGetNode(nodeKey);
		node.setAndOrRule(rule);
		return node;
	}
	
	private AndOrGraphNode createOrGetNode(String key) {
		AndOrGraphNode node = this.nodesMap.get(key);
		if (node == null) {
			node = new AndOrGraphNode();
			this.nodesMap.put(key, node);
			this.addVertex(node);
		}
		return node;
	}
	
	private Iterator<AndOrGraphNode> iterator() {
		return new TopologicalOrderIterator<AndOrGraphNode, AndOrGraphEdge>(this);
	}
}


