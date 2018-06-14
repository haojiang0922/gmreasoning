package gr.ntua.softeng.gm.reasoning.sat.cnf;

import gr.ntua.softeng.gm.model.GoalModelAbstraction;

public class DefaultSatCNFWrapper extends SatCNFWrapper<Atom, Literal, Clause> {

	public DefaultSatCNFWrapper(GoalModelAbstraction goalModel) {
		super(goalModel, new DefaultSatCNFFactory());
	}

}
