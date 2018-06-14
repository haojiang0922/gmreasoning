package gr.ntua.softeng.gm.model;

import java.util.HashSet;
import java.util.Set;

import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;
import gr.ntua.softeng.gm.model.rules.Decomposition;

public class CompositeRule {

	private String goalNodeKey = null;
	// a set that contains only ++S and --D contributions
	private Set<Contribution> contrRulesPos = new HashSet<Contribution>();
	// a set that contains only --S and ++D contributions
	private Set<Contribution> contrRulesNeg = new HashSet<Contribution>();
	private Decomposition decompositionRule = null;
		
	public CompositeRule(Decomposition decompositionRule) {
		this.goalNodeKey = decompositionRule.getParent();
		this.decompositionRule = decompositionRule;
	}
	
	public CompositeRule(String goalNodeKey) {
		this.goalNodeKey = goalNodeKey;
	}
	
	public boolean addContributionRule(Contribution rule) {
		boolean ruleAdded = false;
		if (rule != null && this.goalNodeKey.equals(rule.getTarget())) {
			if (ContributionType.PPS.equals(rule.getType()) || ContributionType.MMD.equals(rule.getType()) ) {
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

	public Set<Contribution> getPosContributionRules() {
		return contrRulesPos;
	}

	public Set<Contribution> getNegContributionRules() {
		return contrRulesNeg;
	}
	
	public Decomposition getDecompositionRule() {
		return decompositionRule;
	}
	
	public String getGoalNodeKey() {
		return this.goalNodeKey;
	}
	
	public void setGoalNodeKey(String goalNodeKey) {
		this.goalNodeKey = goalNodeKey;
	}
}
