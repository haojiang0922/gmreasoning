package gr.ntua.softeng.gm.model.impl;

import java.util.List;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.ContributionType;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.DecompositionType;

public class DefaultGoalModel<G, D, C> extends AbstractGoalModel<G, D, C> {

	@Override
	protected Decomposition createDecomposition(String parent, List<String> childNodes, DecompositionType type, D data) {
		DefaultDecompositionImpl<D> d = new DefaultDecompositionImpl<>(parent, childNodes, type);
		d.setData(data);
		return d;
	}

	@Override
	protected Contribution createContribution(String source, String target, ContributionType type, C data) {
		DefaultContributionImpl<C> c = new DefaultContributionImpl<>(source, target, type);
		c.setData(data);		
		return c;
	}

	@Override
	protected Goal createGoal(String id, G data) {
		DefaultGoalImpl<G> g = new DefaultGoalImpl<>(id);
		g.setData(data);
		return g;
	}

}
