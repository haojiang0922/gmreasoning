package gr.ntua.softeng.gm.reasoning.sat.cnf;

public class DefaultSatCNFFactory implements CNFComponentFactory<Atom, Literal, Clause>{

	@Override
	public Atom createAtom(String key) {
		return new Atom(key);
	}

	@Override
	public Literal createLiteral(Atom atom, boolean isNegated) {
		return new Literal(atom, isNegated);
	}

	@Override
	public Clause createClause() {
		return new Clause();
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
