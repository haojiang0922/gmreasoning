package gr.ntua.softeng.gm.model.impl.ext;

import gr.ntua.softeng.gm.model.ext.WeightedComponent;
import gr.ntua.softeng.gm.model.impl.DefaultGoalImpl;

public class WeightedGoal extends DefaultGoalImpl<WeightedNodeData> implements WeightedComponent {

	public WeightedGoal(String id) {
		super(id);
	}

	@Override
	public Double getWeight() {
		return this.getData().getWeight();
	}
	
	public boolean getIsInverse() {
		return this.getData().isInverse();
	}
	
	public void setIsInverse(boolean value) {
		this.getData().setInverse(value);
	}

}
