package gr.ntua.softeng.gm.reasoning.wfr.components;


public class FuzzyFact extends WeightedFuzzyRule {

	private double degreeOfTruth;
	private FuzzyAtom atom;
	
	public FuzzyFact(FuzzyAtom atom, double degreeOfTruth) {
		this.atom = atom;
		this.degreeOfTruth = degreeOfTruth;
	}
	
	@Override
	public String getRule() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(atom.toStringWithSomeVariable()).append(" = ").append(degreeOfTruth);
		return buffer.toString();
	}

}
