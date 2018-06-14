package gr.ntua.softeng.gm.model.impl;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.comp.Component;

public class DefaultGoalImpl<T> extends Component<T> implements Goal {

	private String id;
	
	public DefaultGoalImpl(String id) {
		this.id = id;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
