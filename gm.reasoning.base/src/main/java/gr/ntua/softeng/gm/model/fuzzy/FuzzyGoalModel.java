package gr.ntua.softeng.gm.model.fuzzy;

import gr.ntua.softeng.gm.model.impl.DefaultGoalModel;
import gr.ntua.softeng.gm.model.impl.ext.WeightedContribution;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;

public class FuzzyGoalModel<G, D> extends DefaultGoalModel<G, D, Double> {

	@Override
	protected Contribution createContribution(String source, String target, ContributionType type, Double weight) {
		return new WeightedContribution(source, target, type, weight);
	}
	
}
