package gr.ntua.softeng.gm.model.impl.ext;

import gr.ntua.softeng.gm.model.ext.WeightedComponent;
import gr.ntua.softeng.gm.model.impl.DefaultContributionImpl;
import gr.ntua.softeng.gm.model.rules.ContributionType;

public class WeightedContribution extends DefaultContributionImpl<Double> implements WeightedComponent {

	public WeightedContribution(String source, String target, ContributionType type, Double weight) {
		super(source, target, type);
		this.setData(weight);
	}

	@Override
	public Double getWeight() {
		return this.getData();
	}

}
