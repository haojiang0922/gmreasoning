package gr.ntua.softeng.gm.model.impl.ext;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.impl.DefaultGoalModel;

public class WeightedNodesGoalModel<D, C> extends DefaultGoalModel<WeightedNodeData, D, C> {

	@Override
	protected Goal createGoal(String id, WeightedNodeData data) {
		WeightedGoal g = new WeightedGoal(id);
		g.setData(data);
		return g;
	}
	
}
