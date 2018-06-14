package gr.ntua.softeng.wtt.sat.opt;

import java.util.Comparator;

import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;

public class IndividualComparator implements Comparator<Individual> {
	
	@Override
	public int compare(Individual ind1, Individual ind2) {
		Objectives obj1 = ind1.getObjectives();
		Objectives obj2 = ind2.getObjectives();
		int comparisonResult = 1;
		if (obj1.dominates(obj2)) {
			comparisonResult = 1;
		} else if (obj2.dominates(obj1)) {
			comparisonResult = -1;
		} else if (ind1.equals(ind2)) {
			// Two individual may have equal objectives even
			// if they represent two different solutions.
			comparisonResult = 0;
		}
		return comparisonResult;
	}
}
