package gr.ntua.softeng.gm.model.impl;

import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;

public class DefaultContributionImpl<T> extends AbstractBinaryRule<T> implements Contribution {

	private ContributionType type;
	
	public DefaultContributionImpl(String source, String target, ContributionType type) {
		super(source, target);
		this.type = type;
	}

	@Override
	public ContributionType getType() {
		return this.type;
	}

}
