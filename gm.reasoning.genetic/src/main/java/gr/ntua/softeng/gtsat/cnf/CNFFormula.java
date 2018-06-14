package gr.ntua.softeng.gtsat.cnf;

import java.util.Iterator;
import java.util.Vector;

public class CNFFormula {

	private Vector<AbstractClause> clauses;
	
	public CNFFormula() {
		this.clauses = new Vector<AbstractClause>();
	}
	
	public CNFFormula(AbstractClause clause) {
		this.clauses = new Vector<AbstractClause>();
		this.addClause(clause);
	}
	
	public CNFFormula(Vector<AbstractClause> clauses) {
		this.clauses = new Vector<AbstractClause>();
		this.addAllClauses(clauses);
	}
	
	public void addClause(AbstractClause clause) {
		this.clauses.addElement(clause);
	}
	
	public void addAllClauses(Vector<AbstractClause> clauses) {
		this.clauses.addAll(clauses);
	}
	
	public Vector<AbstractClause> getClauses() {
		return this.clauses;
	}
	
	public int size() {
		return this.clauses.size();
	}
	
	public void concatenateFormula(CNFFormula formula) {
		this.addAllClauses(formula.clauses);
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		Iterator<AbstractClause> iter = clauses.iterator();
		while (iter.hasNext()) {
			AbstractClause clause = (AbstractClause) iter.next();
			buffer.append(clause);
			if (iter.hasNext()) {
				buffer.append(" ^\n");
			}
		}
		return buffer.toString();
	}
}
