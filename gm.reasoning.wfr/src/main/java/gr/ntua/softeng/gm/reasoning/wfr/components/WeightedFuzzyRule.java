package gr.ntua.softeng.gm.reasoning.wfr.components;

public abstract class WeightedFuzzyRule {
	
	public abstract String getRule();
	
	public String toString() {
		return getRule();
	}

}
