package gr.ntua.softeng.gm.reasoning.wfr.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuzzyConjunction extends WeightedFuzzyRule {

	private FuzzyAtom consequent;
	private List<WeightedFuzzyAtom> antecedents = new ArrayList<>();
	
		
	public FuzzyConjunction(FuzzyAtom consequent, WeightedFuzzyAtom... antecedents) {
		super();
		this.consequent = consequent;
		for (WeightedFuzzyAtom wfa : antecedents) {
			this.antecedents.add(wfa);
		}
		
	}

	public FuzzyConjunction(FuzzyAtom consequent, List<WeightedFuzzyAtom> antecedents) {
		super();
		this.consequent = consequent;
		this.antecedents = antecedents;
	}

	@Override
	public String getRule() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(consequent).append(":-");
		Iterator<WeightedFuzzyAtom> iter = antecedents.iterator();
		while (iter.hasNext()) {
			WeightedFuzzyAtom atom = (WeightedFuzzyAtom) iter.next();
			buffer.append(" ").append(atom);
			if (iter.hasNext()) buffer.append(" &");
		}
		return buffer.toString();
	}

	public WeightedFuzzyRule getCopy(double weightChange) {
		List<WeightedFuzzyAtom> newAntecedents = new ArrayList<>();
		for (WeightedFuzzyAtom weightedFuzzyAtom : antecedents) {
			double newWeight = weightedFuzzyAtom.weight * (1 + weightChange);
			if  (newWeight>1.0) {
				newWeight = 1.0;
			} else if (newWeight<=0.0) {
				newWeight = 0.0;
			}
			WeightedFuzzyAtom a = new WeightedFuzzyAtom(weightedFuzzyAtom.predicateName, weightedFuzzyAtom.variable, newWeight);
			newAntecedents.add(a);
		}
		return new FuzzyConjunction(this.consequent, newAntecedents);
	}
	
}
