package gr.ntua.softeng.gtsat.goalmodel;

import gr.ntua.softeng.gtsat.goalmodel.rules.CompositeRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalContributionRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalDecompositionRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.PrecedenceLinkRule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TemporalGoalModelAbstraction extends GoalModelAbstraction {

	private static final String DECOMPOSITION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_pre_d";
	private static final String CONTRIBUTION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_pre_c";
	
	private Map<String,Set<PrecedenceLinkRule>> preLinkRules = new HashMap<String,Set<PrecedenceLinkRule>>();
	private Map<String,GoalDecompositionRule> decompositionRules = new HashMap<String,GoalDecompositionRule>();
	private Map<String,Set<GoalContributionRule>> contributionRules = new HashMap<String,Set<GoalContributionRule>>();
	
	public void addPreLink(String sourceNodeKey, String targetNodeKey) {
		PrecedenceLinkRule rule = new PrecedenceLinkRule(sourceNodeKey, targetNodeKey);
		Set<PrecedenceLinkRule> preRules = preLinkRules.get(targetNodeKey);
		if (preRules==null) {
			preRules = new HashSet<PrecedenceLinkRule>();
			preLinkRules.put(targetNodeKey, preRules);
		}
		preRules.add(rule);
	}
	
	@Override
	public void addANDDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		GoalDecompositionRule rule = new GoalDecompositionRule(parentNodeKey, childNodeKeys, GoalDecompositionRule.AND);
		decompositionRules.put(parentNodeKey, rule);
	}

	@Override
	public void addORDecomposition(String parentNodeKey, Set<String> childNodeKeys) {
		GoalDecompositionRule rule = new GoalDecompositionRule(parentNodeKey, childNodeKeys, GoalDecompositionRule.OR);
		decompositionRules.put(parentNodeKey, rule);
	}

	private void addContribution(String sourceNodeKey, String targetNodeKey, int type) {
		GoalContributionRule rule = new GoalContributionRule(sourceNodeKey, targetNodeKey, type);
		Set<GoalContributionRule> contrRules = contributionRules.get(targetNodeKey);
		if (contrRules==null) {
			contrRules = new HashSet<GoalContributionRule>();
			contributionRules.put(targetNodeKey, contrRules);
		}
		contrRules.add(rule);
	}
	
	@Override
	public void addPPSContribution(String sourceNodeKey, String targetNodeKey) {
		this.addContribution(sourceNodeKey, targetNodeKey, GoalContributionRule.PPS);
	}

	@Override
	public void addMMSContribution(String sourceNodeKey, String targetNodeKey) {
		this.addContribution(sourceNodeKey, targetNodeKey, GoalContributionRule.MMS);
	}

	@Override
	public void addPPDContribution(String sourceNodeKey, String targetNodeKey) {
		this.addContribution(sourceNodeKey, targetNodeKey, GoalContributionRule.PPD);
	}

	@Override
	public void addMMDContribution(String sourceNodeKey, String targetNodeKey) {
		this.addContribution(sourceNodeKey, targetNodeKey, GoalContributionRule.MMD);
	}

	@Override
	protected Set<GoalDecompositionRule> getDecompositionRules() {
		return new HashSet<GoalDecompositionRule>(this.decompositionRules.values());
	}

	@Override
	protected Set<GoalContributionRule> getContributionRules() {
		Set<GoalContributionRule> allContrRules = new HashSet<GoalContributionRule>();
		for(Set<GoalContributionRule> contrRules : contributionRules.values()) {
			allContrRules.addAll(contrRules);
		}
		return allContrRules;
	}	
	
	@Override
	public Set<CompositeRule> getRules() {
		for (String nodeKey : preLinkRules.keySet()) {
			Set<PrecedenceLinkRule> rules = preLinkRules.get(nodeKey);
			String cloneKey = cloneNode(nodeKey);
		}
		return super.getRules();
	}
	
	private String cloneNode(String nodeKey) {
		boolean cloneCreated = false;
		String cloneNodeKey = nodeKey + DECOMPOSITION_PSEUDO_NODE_SUFFIX;
		// Update decomposition
		if (this.decompositionRules.containsKey(nodeKey)) {
			GoalDecompositionRule decompRule = this.decompositionRules.get(nodeKey);
			decompRule.setParentNodeKey(cloneNodeKey);
			cloneCreated = true;
		}
		// Update contributions
		if (this.contributionRules.containsKey(nodeKey)) {
			Set<GoalContributionRule> contrRules = this.contributionRules.get(nodeKey);
			for (GoalContributionRule r : contrRules) {
				r.setTargetNodeKey(cloneNodeKey);
			}
			cloneCreated = true;
		}
		return cloneCreated ? cloneNodeKey : null;
	}
}
