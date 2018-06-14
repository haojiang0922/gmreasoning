package gr.ntua.softeng.gm.reasoning.sat.cnf;

import java.util.ArrayList;
import java.util.Iterator;

public class Clause {

	private ArrayList<Literal> literals = new ArrayList<Literal>();

	public ArrayList<Literal> getLiterals() {
		return literals;
	}

	public void addLiteral(Literal literal) {
		this.literals.add(literal);
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
	
	public int[] getDIMACSFormat() {
		int[] dimacs = new int[literals.size()];
		for(int i=0; i<literals.size(); i++) {
			dimacs[i] = literals.get(i).getLiteralCode();
		}
		return dimacs;
	}
	
	public boolean isHard() {
		return true;
	}
}
