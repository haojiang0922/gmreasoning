package gr.ntua.softeng.gtsat.cnf;

import java.util.HashSet;
import java.util.Set;

public class Atom {

	private int id;
	private String goalNodeKey;
	
	private Set<Literal> positiveLiterals = new HashSet<Literal>();
	private Set<Literal> negativeLiterals = new HashSet<Literal>();
	
	private Set<AbstractClause> positiveClauses = new HashSet<AbstractClause>();
	private Set<AbstractClause> negativeClauses = new HashSet<AbstractClause>();
	
	public Atom(String goalNodeKey, int id) {
		this.id = id;
		this.goalNodeKey = goalNodeKey;
	}
	
	public Atom(String goalNodeKey) {
		this.goalNodeKey = goalNodeKey;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("<").append(getGoalNodeKey()).append(">");
//		buffer.append("<").append(getGoalNodeKey()).append("-").append(id).append(">");
		return buffer.toString();
	}

	public String getGoalNodeKey() {
		return goalNodeKey;
	}

	public void setGoalNodeKey(String goalNodeKey) {
		this.goalNodeKey = goalNodeKey;
	}
	
	public void addPositiveLiteral(Literal literal) {
		this.positiveLiterals.add(literal);
	}
	
	public void addNegativeLiteral(Literal literal) {
		this.negativeLiterals.add(literal);
	}

	public void addPositiveClause(AbstractClause c) {
		this.positiveClauses.add(c);
	}
	
	public void addNegativeClause(AbstractClause c) {
		this.negativeClauses.add(c);
	}
	
	public Set<Literal> getPositiveLiterals() {
		return positiveLiterals;
	}

	public Set<Literal> getNegativeLiterals() {
		return negativeLiterals;
	}

	public Set<AbstractClause> getPositiveClauses() {
		return positiveClauses;
	}

	public Set<AbstractClause> getNegativeClauses() {
		return negativeClauses;
	}
	
	
}
