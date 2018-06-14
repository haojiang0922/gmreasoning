package gr.ntua.softeng.gm.reasoning.sat.cnf.weights;

import gr.ntua.softeng.gm.reasoning.sat.cnf.Atom;
import gr.ntua.softeng.gm.reasoning.sat.cnf.CNFComponentFactory;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Literal;

public interface MaxSatCNFComponentFactory<A extends Atom, L extends Literal, C extends WeightedClause> extends CNFComponentFactory<A, L, C>{

}
