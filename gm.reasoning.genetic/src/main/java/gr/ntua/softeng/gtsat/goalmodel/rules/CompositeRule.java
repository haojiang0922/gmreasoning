package gr.ntua.softeng.gtsat.goalmodel.rules;

import java.util.HashSet;
import java.util.Set;

public class CompositeRule {

	private String goalNodeKey = null;
	// a set that contains only ++S and --D contributions
	private Set<GoalContributionRule> contrRulesPos = new HashSet<GoalContributionRule>();
	// a set that contains only --S and ++D contributions
	private Set<GoalContributionRule> contrRulesNeg = new HashSet<GoalContributionRule>();
	private GoalDecompositionRule decompositionRule = null;
		
	public CompositeRule(GoalDecompositionRule decompositionRule) {
		this.goalNodeKey = decompositionRule.getParentNodeKey();
		this.decompositionRule = decompositionRule;
	}
	
	public CompositeRule(String goalNodeKey) {
		this.goalNodeKey = goalNodeKey;
	}
	
	public boolean addContributionRule(GoalContributionRule rule) {
		boolean ruleAdded = false;
		if (rule != null && this.goalNodeKey.equals(rule.getTargetNodeKey())) {
			if (rule.isPPS() || rule.isMMD()) {
				this.contrRulesPos.add(rule);
			} else {
				this.contrRulesNeg.add(rule);
			}
			ruleAdded = true;
		}
		return ruleAdded;
	}
	
	public boolean hasContributions() {
		return !this.contrRulesPos.isEmpty() && !this.contrRulesNeg.isEmpty();
	}
	
	public boolean hasDecomposition() {
		return !(this.decompositionRule == null);
	}

	public Set<GoalContributionRule> getPosContributionRules() {
		return contrRulesPos;
	}

	public Set<GoalContributionRule> getNegContributionRules() {
		return contrRulesNeg;
	}
	
	public GoalDecompositionRule getDecompositionRule() {
		return decompositionRule;
	}
	
	public String getGoalNodeKey() {
		return this.goalNodeKey;
	}
}
