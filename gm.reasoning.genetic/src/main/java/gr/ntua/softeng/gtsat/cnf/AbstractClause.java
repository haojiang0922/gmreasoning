package gr.ntua.softeng.gtsat.cnf;

import java.util.Iterator;
import java.util.Vector;

public abstract class AbstractClause {

	private Vector<Literal> literals = new Vector<Literal>();

	public Vector<Literal> getLiterals() {
		return literals;
	}

	public void addLiteral(Literal literal) {
		this.literals.addElement(literal);
	}
	
	public int[] getDIMACSFormat() {
		int[] dimacs = new int[literals.size()];
		for(int i=0; i<literals.size(); i++) {
			dimacs[i] = literals.get(i).getLiteralCode();
		}
		return dimacs;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("(");
		Iterator<Literal> literalIter = literals.iterator();
		while (literalIter.hasNext()) {
			Literal lit = (Literal) literalIter.next();
			buffer.append(lit);
			if (literalIter.hasNext()) {
				buffer.append(" v ");
			}
		}
		buffer.append(")");
		return buffer.toString();
	}
	
	public abstract boolean isHard();
	public abstract int getWeight();
}
