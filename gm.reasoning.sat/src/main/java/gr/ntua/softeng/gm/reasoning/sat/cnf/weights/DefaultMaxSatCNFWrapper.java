package gr.ntua.softeng.gm.reasoning.sat.cnf.weights;

import gr.ntua.softeng.gm.model.GoalModelAbstraction;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Atom;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Literal;

public class DefaultMaxSatCNFWrapper extends MaxSatCNFWrapper<Atom, Literal, WeightedClause>{

	public DefaultMaxSatCNFWrapper(GoalModelAbstraction goalModel) {
		super(goalModel, new DefaultMaxSatCNFFactory());
	}

}
