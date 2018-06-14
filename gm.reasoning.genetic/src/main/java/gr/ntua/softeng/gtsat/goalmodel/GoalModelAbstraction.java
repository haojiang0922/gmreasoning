package gr.ntua.softeng.gtsat.goalmodel;

import gr.ntua.softeng.gtsat.goalmodel.rules.CompositeRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.ConstraintRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalContributionRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalDecompositionRule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoalModelAbstraction implements IGoalModelAbstraction {
	
	private Set<GoalDecompositionRule> decompositionRules = new HashSet<GoalDecompositionRule>();
	private Set<GoalContributionRule> contributionRules = new HashSet<GoalContributionRule>();
	private Set<ConstraintRule> constraints = new HashSet<ConstraintRule>();
	
	private Map<String,Integer> nodeWeights = new HashMap<String,Integer>();
	
	@Override
	public void addANDDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		GoalDecompositionRule rule = new GoalDecompositionRule(parentNodeKey, childNodeKeys, GoalDecompositionRule.AND);
		this.decompositionRules.add(rule);
	}

	@Override
	public void addORDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		GoalDecompositionRule rule = new GoalDecompositionRule(parentNodeKey, childNodeKeys, GoalDecompositionRule.OR);
		this.decompositionRules.add(rule);
	}

	@Override
	public void addPPSContribution(String sourceNodeKey, String targetNodeKey) {
		GoalContributionRule rule = new GoalContributionRule(sourceNodeKey, targetNodeKey, GoalContributionRule.PPS);
		this.contributionRules.add(rule);
	}

	@Override
	public void addMMSContribution(String sourceNodeKey, String targetNodeKey) {
		GoalContributionRule rule = new GoalContributionRule(sourceNodeKey, targetNodeKey, GoalContributionRule.MMS);
		this.contributionRules.add(rule);
	}

	@Override
	public void addPPDContribution(String sourceNodeKey, String targetNodeKey) {
		GoalContributionRule rule = new GoalContributionRule(sourceNodeKey, targetNodeKey, GoalContributionRule.PPD);
		this.contributionRules.add(rule);
	}

	@Override
	public void addMMDContribution(String sourceNodeKey, String targetNodeKey) {
		GoalContributionRule rule = new GoalContributionRule(sourceNodeKey, targetNodeKey, GoalContributionRule.MMD);
		this.contributionRules.add(rule);
	}
	
	@Override
	public void addWeightedNode(String nodeKey, int nodeWeight) {
		this.nodeWeights.put(nodeKey, nodeWeight);
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
	
	private void handleDecomposition(GoalDecompositionRule rule, Set<CompositeRule> rules, Set<GoalContributionRule> copyOfContrRules) {
		CompositeRule compositeRule = new CompositeRule(rule);
		String nodeKey = rule.getParentNodeKey();
		Iterator<GoalContributionRule> ruleIter = copyOfContrRules.iterator();
		while (ruleIter.hasNext()) {
			GoalContributionRule contrRule = (GoalContributionRule) ruleIter.next();
			if (contrRule.getTargetNodeKey().equals(nodeKey)) {
				compositeRule.addContributionRule(contrRule);
				ruleIter.remove();
			}
		}
		rules.add(compositeRule);
	}
	
	private void handleContributions(Set<CompositeRule> rules, Set<GoalContributionRule> copyOfContrRules) {
		Map<String, CompositeRule> compositeRuleMap = new HashMap<String, CompositeRule>();
		for (GoalContributionRule rule : copyOfContrRules) {
			String targetNodeKey = rule.getTargetNodeKey();
			CompositeRule compRule = compositeRuleMap.get(targetNodeKey);
			if (compRule == null) {
				compRule = new CompositeRule(targetNodeKey);
				compositeRuleMap.put(targetNodeKey, compRule);
			}
			compRule.addContributionRule(rule);
		}
		rules.addAll(compositeRuleMap.values());
	}
	
	public Set<CompositeRule> getRules() {
		Set<GoalContributionRule> copyOfContrRules = new HashSet<GoalContributionRule>();
		copyOfContrRules.addAll(this.getContributionRules());
		Set<CompositeRule> rules = new HashSet<CompositeRule>();
		for (GoalDecompositionRule r : this.getDecompositionRules()) {
			this.handleDecomposition(r, rules, copyOfContrRules);
		}			
		handleContributions(rules, copyOfContrRules);
		return rules;
	}
	
	public Set<ConstraintRule> getConstraints() {
		return this.constraints;
	}
	
	public Map<String,Integer> getNodeWeights() {
		return this.nodeWeights;
	}
	
	protected Set<GoalDecompositionRule> getDecompositionRules() {
		return this.decompositionRules;
	}
	
	protected Set<GoalContributionRule> getContributionRules() {
		return this.contributionRules;
	}
}
