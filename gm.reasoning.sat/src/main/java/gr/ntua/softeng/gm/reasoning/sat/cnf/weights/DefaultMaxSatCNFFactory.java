package gr.ntua.softeng.gm.reasoning.sat.cnf.weights;

import gr.ntua.softeng.gm.reasoning.sat.cnf.Atom;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Literal;

public class DefaultMaxSatCNFFactory implements MaxSatCNFComponentFactory<Atom, Literal, WeightedClause> {

	@Override
	public WeightedClause createClause() {
		return new WeightedClause();
	}

	@Override
	public Atom createAtom(String key) {
		return new Atom(key);
	}

	@Override
	public Literal createLiteral(Atom atom, boolean isNegated) {
		return new Literal(atom, isNegated);
	}

	@Override
	public Literal createNegatedLiteral(Literal literal) {
		Literal negLiteral = this.createLiteral(literal.getAtom(), !literal.isNegated());
		return negLiteral;
	}
	
	@Override
	public Literal createLiteral(Literal literal) {
		Literal literalClone = this.createLiteral(literal.getAtom(), literal.isNegated());
		return literalClone;
	}
}
