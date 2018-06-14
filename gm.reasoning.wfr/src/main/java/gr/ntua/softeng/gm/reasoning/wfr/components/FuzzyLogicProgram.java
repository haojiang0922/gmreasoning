package gr.ntua.softeng.gm.reasoning.wfr.components;

import java.util.ArrayList;
import java.util.List;

public class FuzzyLogicProgram {

	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private List<WeightedFuzzyRule> rules = new ArrayList<>();
	private List<WeightedFuzzyRule> facts = new ArrayList<>();
	
	public FuzzyLogicProgram() {
		this.initializeFactsList();
		this.rules.add(new Comment("RULES"));
	}
	
	private void initializeFactsList() {
		this.facts = new ArrayList<>();
		this.facts.add(new Comment("FACTS"));
	}
		
	public void addFact(FuzzyFact f) {
		this.facts.add(f);
	}
	public void addFacts(List<FuzzyFact> facts) {
		this.facts.addAll(facts);
	}
	
	public void addRule(WeightedFuzzyRule rule) {
		this.rules.add(rule);
	}
	public void addRules(List<WeightedFuzzyRule> rules) {
		this.rules.addAll(rules);
	}
	
	public void reset() {
		this.initializeFactsList();
	}
	
	public String getProgram() {
		StringBuilder buffer = new StringBuilder();
		this.appendRules(buffer, this.facts);
		this.appendRules(buffer, this.rules);
		return buffer.toString();
	}
	
	private void appendRules(StringBuilder buffer, List<WeightedFuzzyRule> rules) {
		for (WeightedFuzzyRule r : rules) {
			buffer.append(r.getRule()).append(NEW_LINE);
		}
	}
	
}
