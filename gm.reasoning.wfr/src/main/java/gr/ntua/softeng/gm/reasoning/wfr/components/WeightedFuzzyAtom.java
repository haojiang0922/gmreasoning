package gr.ntua.softeng.gm.reasoning.wfr.components;


public class WeightedFuzzyAtom extends FuzzyAtom {
	
	protected double weight;

	public WeightedFuzzyAtom(String predicateName, String variable) {
		this(predicateName, variable, null);
	}
	
	public WeightedFuzzyAtom(String predicateName, String variable, Double weight) {
		super(predicateName, variable);
		if (weight != null)	this.weight = weight;
		else this.weight = 1.0;
	}

	public String toString(){
		StringBuilder buffer = new StringBuilder();
		buffer.append(weight).append(":");
		buffer.append(super.toString());
		return buffer.toString();
	}
	
}
