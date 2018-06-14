package gr.ntua.softeng.gm.reasoning.wfr.components.factory;

import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyAtom;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyConjunction;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyFact;
import gr.ntua.softeng.gm.reasoning.wfr.components.WeightedFuzzyAtom;
import gr.ntua.softeng.gm.reasoning.wfr.components.WeightedFuzzyRule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FuzzyRulesFactory {

	public static final String HIGH_SAT = "HighSat";
	public static final String LOW_SAT = "LowSat";
	private static final String HOLDS = "Holds";
	
	private static final Random randomGen = new Random(System.currentTimeMillis());
		
	public List<FuzzyFact> createNodeRandomFuzzyFacts(String nodeName) {
		List<FuzzyFact> rules = new ArrayList<>(2);
		double wHigh = randomGen.nextDouble(), wLow = randomGen.nextDouble();
		rules.add(new FuzzyFact(new FuzzyAtom(HIGH_SAT, nodeName), wHigh));
		rules.add(new FuzzyFact(new FuzzyAtom(LOW_SAT, nodeName), wLow));
		return rules;
	}
	
	public List<FuzzyFact> createNodeFuzzyFacts(String nodeName, double wHigh, double wLow) {
		List<FuzzyFact> rules = new ArrayList<>(2);
		rules.add(new FuzzyFact(new FuzzyAtom(HIGH_SAT, nodeName), wHigh));
		rules.add(new FuzzyFact(new FuzzyAtom(LOW_SAT, nodeName), wLow));
		return rules;
	}
	
	public WeightedFuzzyRule createConditionFuzzyFact(String condition, Boolean value) {
		if (value != null && value.booleanValue() ) {
			return new FuzzyFact(new FuzzyAtom(HOLDS, condition), 1.0);
		} else {
			return new FuzzyFact(new FuzzyAtom(HOLDS, condition), 0.0);
		}
		
	}
	
	private WeightedFuzzyRule createContributionRule(String target, String source, Double weight, String targetPredicate, String sourcePredicate) {
		WeightedFuzzyAtom sourceAtom = new WeightedFuzzyAtom(sourcePredicate, source, weight);
		return new FuzzyConjunction(new FuzzyAtom(targetPredicate, target), sourceAtom);
	}
	
	private WeightedFuzzyRule createPPSRule(String target, String source, Double weight) {
		return this.createContributionRule(target, source, weight, HIGH_SAT, HIGH_SAT);
	}
	
	private WeightedFuzzyRule createMMSRule(String target, String source, Double weight) {
		return this.createContributionRule(target, source, weight, LOW_SAT, HIGH_SAT);
	}
	
	private WeightedFuzzyRule createPPDRule(String target, String source, Double weight) {
		return this.createContributionRule(target, source, weight, HIGH_SAT, LOW_SAT);
	}
	
	private WeightedFuzzyRule createMMDRule(String target, String source, Double weight) {
		return this.createContributionRule(target, source, weight, LOW_SAT, LOW_SAT);
	}
	
	private String getPseudoGoalName(String goalName, Double weight) {
		return goalName;//PseudoNodeUtils.getGoalPseudoNodeName(goalName, weight);
	}
	
	private List<WeightedFuzzyRule> createCondRelatedRules(String pseudoSource, String source, Collection<String> conditions, String predicate) {
		List<WeightedFuzzyRule> rules = new ArrayList<WeightedFuzzyRule>();
		for (String cond : conditions) {
			WeightedFuzzyAtom conditionAtom = new WeightedFuzzyAtom(HOLDS, cond);
			WeightedFuzzyAtom sourceAtom = new WeightedFuzzyAtom(predicate, source);
			WeightedFuzzyRule r = new FuzzyConjunction(new FuzzyAtom(predicate, pseudoSource), conditionAtom, sourceAtom);
			rules.add(r);
		}
		return rules;
	}
	
	public List<WeightedFuzzyRule> createPPSRules(String target, String source, Double weight, Collection<String> conditions) {
		String pseudoSourceNodeName = this.getPseudoGoalName(source, weight);
		WeightedFuzzyRule contributionRule = this.createPPSRule(target, pseudoSourceNodeName, weight);
		List<WeightedFuzzyRule> conditionRelatedRules = this.createCondRelatedRules(pseudoSourceNodeName, source, conditions, HIGH_SAT);
		conditionRelatedRules.add(contributionRule);
		return conditionRelatedRules;
	}
	
	public List<WeightedFuzzyRule> createMMSRules(String target, String source, Double weight, Collection<String> conditions) {
		String pseudoSourceNodeName = this.getPseudoGoalName(source, weight);
		WeightedFuzzyRule contributionRule = this.createMMSRule(target, pseudoSourceNodeName, weight);
		List<WeightedFuzzyRule> conditionRelatedRules = this.createCondRelatedRules(pseudoSourceNodeName, source, conditions, HIGH_SAT);
		conditionRelatedRules.add(contributionRule);
		return conditionRelatedRules;
	}
	
	public List<WeightedFuzzyRule> createPPDRules(String target, String source, Double weight, Collection<String> conditions) {
		String pseudoSourceNodeName = this.getPseudoGoalName(source, weight);
		WeightedFuzzyRule contributionRule = this.createPPDRule(target, pseudoSourceNodeName, weight);
		List<WeightedFuzzyRule> conditionRelatedRules = this.createCondRelatedRules(pseudoSourceNodeName, source, conditions, LOW_SAT);
		conditionRelatedRules.add(contributionRule);
		return conditionRelatedRules;
	}
	
	public List<WeightedFuzzyRule> createMMDRules(String target, String source, Double weight, Collection<String> conditions) {
		String pseudoSourceNodeName = this.getPseudoGoalName(source, weight);
		WeightedFuzzyRule contributionRule = this.createMMDRule(target, pseudoSourceNodeName, weight);
		List<WeightedFuzzyRule> conditionRelatedRules = this.createCondRelatedRules(pseudoSourceNodeName, source, conditions, LOW_SAT);
		conditionRelatedRules.add(contributionRule);
		return conditionRelatedRules;
	}
	
	public List<WeightedFuzzyRule> createAndDecompositionRules(String parent, Collection<String> children) {
		List<WeightedFuzzyRule> rules = new ArrayList<WeightedFuzzyRule>();
		List<WeightedFuzzyAtom> antecedents = new ArrayList<WeightedFuzzyAtom>();
		for (String child : children) {
			antecedents.add(new WeightedFuzzyAtom(HIGH_SAT, child));
			WeightedFuzzyRule lowSatRule = new FuzzyConjunction(new FuzzyAtom(LOW_SAT, parent), new WeightedFuzzyAtom(LOW_SAT, child));
			rules.add(lowSatRule);
		}		
		// add normal and decomposition rule
		rules.add(new FuzzyConjunction(new FuzzyAtom(HIGH_SAT, parent), antecedents));
		return rules;
	}
	
	public List<WeightedFuzzyRule> createOrDecompositionRules(String parent, Collection<String> children) {
		List<WeightedFuzzyRule> rules = new ArrayList<WeightedFuzzyRule>();
		List<WeightedFuzzyAtom> antecedents = new ArrayList<WeightedFuzzyAtom>();
		for (String child : children) {
			antecedents.add(new WeightedFuzzyAtom(LOW_SAT, child));
			WeightedFuzzyRule highSatRule = new FuzzyConjunction(new FuzzyAtom(HIGH_SAT, parent), new WeightedFuzzyAtom(HIGH_SAT, child));
			rules.add(highSatRule);
		}
		// add coresponding or decomposition rule
		rules.add(new FuzzyConjunction(new FuzzyAtom(LOW_SAT, parent), antecedents));
		return rules;
	}
		
	public String getHighSatQueryForNode(String node) {
		StringBuilder bf = new StringBuilder();
		bf.append(HIGH_SAT).append(node).append("(a)");
		return bf.toString();
	}
	
	public String getLowSatQueryForNode(String node) {
		StringBuilder bf = new StringBuilder();
		bf.append(LOW_SAT).append(node).append("(a)");
		return bf.toString();
	}
}
