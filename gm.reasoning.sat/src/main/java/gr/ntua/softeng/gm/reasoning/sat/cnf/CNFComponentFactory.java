package gr.ntua.softeng.gm.reasoning.sat.cnf;

public interface CNFComponentFactory<A extends Atom, L extends Literal, C extends Clause> {

	public A createAtom(String key);
	public L createLiteral(A atom, boolean isNegated);
	public L createLiteral(L literal);
	public C createClause();
	public L createNegatedLiteral(L literal);
}
