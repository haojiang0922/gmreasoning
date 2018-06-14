package gr.ntua.softeng.gm.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gr.ntua.softeng.gm.model.impl.DefaultContributionImpl;
import gr.ntua.softeng.gm.model.impl.DefaultDecompositionImpl;
import gr.ntua.softeng.gm.model.impl.ext.PrecedenceLink;
import gr.ntua.softeng.gm.model.impl.ext.PreconditionLink;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.DecompositionType;
import gr.ntua.softeng.gm.model.view.andor.AndOrGraph;
import gr.ntua.softeng.gm.model.view.andor.AndOrGraphEvaluator;
import gr.ntua.softeng.gm.model.view.andor.AndOrRule;
import gr.ntua.softeng.gm.model.view.andor.AndOrTree;
import gr.ntua.softeng.gm.model.view.andor.Evaluator;

public class GoalModelAbstraction implements IGoalModelAbstraction {
	
	private Set<ConstraintRule> constraints = new HashSet<ConstraintRule>();
	private Set<PrecedenceLink<?>> precedenceRules = new HashSet<PrecedenceLink<?>>();
	// Key = parentNodeKey
	private Set<Decomposition> decompositionRules = new HashSet<Decomposition>();
	private Set<String> childNodeKeys = new HashSet<String>();
	private Set<String> parentNodeKeys = new HashSet<String>();
	// Key = targetNodeKey
	private Map<String,Set<Contribution>> posContributionRules = new HashMap<String,Set<Contribution>>();
	private Map<String,Set<Contribution>> negContributionRules = new HashMap<String,Set<Contribution>>();
	private Map<String,Set<PreconditionLink<?>>> preconditionRules = new HashMap<String,Set<PreconditionLink<?>>>();
	
	private ObservableWeights nodeWeights = new ObservableWeights();
	
	@Override
	public void addANDDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		this.childNodeKeys.addAll(childNodeKeys);
		this.parentNodeKeys.add(parentNodeKey);
		Decomposition rule = new DefaultDecompositionImpl<>(parentNodeKey, childNodeKeys, DecompositionType.AND);
		this.decompositionRules.add(rule);
	}

	@Override
	public void addORDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		this.childNodeKeys.addAll(childNodeKeys);
		this.parentNodeKeys.add(parentNodeKey);
		Decomposition rule = new DefaultDecompositionImpl<>(parentNodeKey, childNodeKeys, DecompositionType.OR);
		this.decompositionRules.add(rule);
	}

	private void addContribution(String targetNodeKey, Contribution rule, Map<String,Set<Contribution>> rulesMap) {
		Set<Contribution> contrRules = rulesMap.get(targetNodeKey);
		if (contrRules == null) {
			contrRules = new HashSet<Contribution>();
		}
		contrRules.add(rule);
		rulesMap.put(targetNodeKey,contrRules);
	}
	
	@Override
	public void addPPSContribution(String sourceNodeKey, String targetNodeKey) {
		Contribution rule = new DefaultContributionImpl<>(sourceNodeKey, targetNodeKey, ContributionType.PPS);
		this.addContribution(targetNodeKey, rule, this.posContributionRules);
	}

	@Override
	public void addMMSContribution(String sourceNodeKey, String targetNodeKey) {
		Contribution rule = new DefaultContributionImpl<>(sourceNodeKey, targetNodeKey, ContributionType.MMS);
		this.addContribution(targetNodeKey, rule, this.negContributionRules);
	}

	@Override
	public void addPPDContribution(String sourceNodeKey, String targetNodeKey) {
		Contribution rule = new DefaultContributionImpl<>(sourceNodeKey, targetNodeKey, ContributionType.PPD);
		this.addContribution(targetNodeKey, rule, this.negContributionRules);
	}

	@Override
	public void addMMDContribution(String sourceNodeKey, String targetNodeKey) {
		Contribution rule = new DefaultContributionImpl<>(sourceNodeKey, targetNodeKey, ContributionType.MMD);
		this.addContribution(targetNodeKey, rule, this.posContributionRules);
	}
	
	@Override
	public void addWeightedNode(String nodeKey, Integer nodeWeight) {
		this.nodeWeights.setNodeWeight(nodeKey, nodeWeight);
	}
	
	@Override
	public void addGoal(String nodeKey) {
		ConstraintRule rule = new ConstraintRule(nodeKey, true);
		this.constraints.add(rule);
	}
	
	@Override
	public void addAntiGoal(String nodeKey) {
		ConstraintRule rule = new ConstraintRule(nodeKey, false);
		this.constraints.add(rule);
	}
	
	@Override
	public void addPrecedenceLink(String sourceNodeKey, String targetNodeKey) {
		PrecedenceLink<?> rule = new PrecedenceLink<>(sourceNodeKey, targetNodeKey);
		this.precedenceRules.add(rule);
	}

	@Override
	public void addPreconditionLink(String sourceNodeKey, String targetNodeKey) {
		PreconditionLink<?> rule = new PreconditionLink<>(sourceNodeKey, targetNodeKey);
		Set<PreconditionLink<?>> preRules = this.preconditionRules.get(targetNodeKey);
		if (preRules == null) {
			preRules = new HashSet<PreconditionLink<?>>();
		}
		preRules.add(rule);
		this.preconditionRules.put(targetNodeKey,preRules);
	}

	public Set<ConstraintRule> getConstraints() {
		return this.constraints;
	}
	
	public ObservableWeights getNodeWeights() {
		return this.nodeWeights;
	}

	@Override
	public void updateWeightedNode(String nodeKey, Integer newNodeWeight, UpdateHandler handler) {
		this.nodeWeights.updateNodeWeight(nodeKey, newNodeWeight, handler);
	}

	@Override
	public void updateWeightedNodes(Map<String, Integer> newNodeWeights, UpdateHandler handler) {
		this.nodeWeights.updateNodeWeights(newNodeWeights, handler);
	}
	
	public List<AndOrRule> getSortedRules() {
		AndOrGraph graph  = new AndOrGraph(this);
		return graph.getSortedRulesList();
	}
	
	public Evaluator getEvaluator() {
		AndOrGraph graph  = new AndOrGraph(this);
		return new AndOrGraphEvaluator(graph);
	}
	
	public Collection<AndOrRule> getRules() {
		AndOrTree tree  = new AndOrTree(this);
		return tree.getRules();
	}
	
	public Set<Decomposition> getDecompositionRules() {
		return decompositionRules;
	}

	public Map<String, Set<Contribution>> getPosContributionRules() {
		return posContributionRules;
	}

	public Map<String, Set<Contribution>> getNegContributionRules() {
		return negContributionRules;
	}

	public Map<String, Set<PreconditionLink<?>>> getPreconditionRules() {
		return preconditionRules;
	}
	
	public Set<String> getLeafNodeKeys() {
		Set<String> leafNodeKeys = new HashSet<String>(this.childNodeKeys);
		Set<String> decomposedNodeKeys = this.parentNodeKeys;
		leafNodeKeys.removeAll(decomposedNodeKeys);
		return leafNodeKeys;
	}
}
