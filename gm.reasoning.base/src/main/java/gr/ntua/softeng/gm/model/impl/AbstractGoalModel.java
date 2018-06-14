package gr.ntua.softeng.gm.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.GoalModel;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.DecompositionType;
import gr.ntua.softeng.gm.model.rules.GoalModelRule;

public abstract class AbstractGoalModel<G, D, C> implements GoalModel<G, D, C> {
	
	private Map<String, Goal> goalNodeCatalog = new HashMap<>();
	private Set<GoalModelRule> rules = new HashSet<>();
	private DirectedGraph<Goal, DefaultEdge> graph;
	
	public AbstractGoalModel() {
		this.graph = new DefaultDirectedGraph<Goal, DefaultEdge>(new ClassBasedEdgeFactory<Goal, DefaultEdge>(DefaultEdge.class));
	}
	
	private void addNodeToCatalog(Goal node) {
		this.goalNodeCatalog.put(node.getId(), node);
	}
		
	protected void addRule(GoalModelRule rule) {
		this.rules.add(rule);
	}
	
	protected void addEdge(Goal source, Goal target) {
		this.graph.addEdge(source, target);
	}
	
	@Override
	public void addDecomposition(Goal parent, List<Goal> childNodes, DecompositionType type) {
		this.addDecomposition(parent, childNodes, type, null);
	}
	
	@Override
	public void addDecomposition(Goal parent, List<Goal> childNodes, DecompositionType type, D data) {
		List<String> childNodeIds = new ArrayList<>();
		for (Goal cn : childNodes) {
			childNodeIds.add(cn.getId());
			// Add the corresponding edge to the graph
			this.addEdge(cn, parent);
		}
		// Create the decomposition goal model rule
		Decomposition r = this.createDecomposition(parent.getId(), childNodeIds, type, data);
		this.addRule(r);
	}
	
	protected abstract Decomposition createDecomposition(String parent, List<String> childNodes, DecompositionType type, D data);

	@Override
	public void addContribution(Goal source, Goal target, ContributionType type) {
		this.addContribution(source, target, type, null);
	}
	
	@Override
	public void addContribution(Goal source, Goal target, ContributionType type, C data) {
		// Add the corresponding edge to the graph
		this.addEdge(source, target);
		// Create the contribution goal model rule
		Contribution r = this.createContribution(source.getId(), target.getId(), type, data);
		this.addRule(r);
	}

	protected abstract Contribution createContribution(String source, String target, ContributionType type, C data);
	
	@Override
	public List<Goal> getRootNodes() {
		List<Goal> rootNodes = new ArrayList<>();
		for (Goal graphNode : this.graph.vertexSet()) {
			int outDegree = this.graph.outDegreeOf(graphNode);
			if (outDegree==0) {
				rootNodes.add(graphNode);
			}
		}
		return rootNodes;
	}

	@Override
	public List<Goal> getLeafNodes() {
		List<Goal> leafNodes = new ArrayList<>();
		for (Goal graphNode : this.graph.vertexSet()) {
			int inDegree = this.graph.inDegreeOf(graphNode);
			if (inDegree==0) {
				leafNodes.add(graphNode);
			}
		}
		return leafNodes;
	}

	@Override
	public List<Goal> getAllNodes() {
		Collection<Goal> nodes = this.goalNodeCatalog.values();
		List<Goal> nodesList = new ArrayList<>(nodes);
		return nodesList;
	}

	@Override
	public Goal goal(String id, G data) {
		Goal g = this.goalNodeCatalog.get(id);
		if (g == null) {
			g = this.createGoal(id, data);
			this.graph.addVertex(g);
			this.addNodeToCatalog(g);
		}
		return g;
	}
	
	@Override
	public Goal goal(String id) {
		return this.goal(id, null);
	}
	
	protected abstract Goal createGoal(String id, G data);
	
	@Override
	public Set<GoalModelRule> getRules() {
		return this.rules;
	}
	
}
