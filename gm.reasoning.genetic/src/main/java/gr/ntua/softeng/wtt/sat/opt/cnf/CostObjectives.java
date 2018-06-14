package gr.ntua.softeng.wtt.sat.opt.cnf;

import org.opt4j.core.IntegerValue;
import org.opt4j.core.Objective;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;

public class CostObjectives extends Objectives {

	private static final String OBJECTIVE_COST = "cost";
	private static final String OBJECTIVE_NUM_OF_FALSE_CLAUSES = "falseClauses";
	
	private final Objective costObjective = new Objective(OBJECTIVE_COST, Sign.MAX);
	private final Objective falseClausesObjective = new Objective(OBJECTIVE_NUM_OF_FALSE_CLAUSES, Sign.MIN);
	
	private Integer cost = null;
	private Integer numOfFalseClauses = null;
	
	public CostObjectives(Integer cost, Integer numOfFalseClauses) {
		this.setCostObjective(cost);
		this.setFalseClausesObjective(numOfFalseClauses);
	}
	
	private void setCostObjective(Integer cost) {
		this.add(costObjective, new IntegerValue(cost));
		this.cost = cost;
	}
	
	private void setFalseClausesObjective(Integer numOfFalseClauses) {
		this.add(falseClausesObjective, new IntegerValue(numOfFalseClauses));
		this.numOfFalseClauses = numOfFalseClauses;
	}
	
	public int getCost() {
		if (this.cost == null) throw new IllegalStateException();
		return this.cost;
	}
	
	public int getNumOfFalseClauses() {
		if (this.numOfFalseClauses == null) throw new IllegalStateException();
		return this.numOfFalseClauses;
	}
	
	@Override
	public boolean dominates(Objectives opponent) {
		int cost1 = this.getCost();
		int numOfFalse1 = this.getNumOfFalseClauses();
		CostObjectives obj = (CostObjectives)opponent;
		int cost2 = obj.getCost();
		int numOfFalse2 = obj.getNumOfFalseClauses();
		//
		int expression = numOfFalse2 - numOfFalse1;
		if ( expression == 0 ) {
			expression = cost1 - cost2;
		}
		return expression > 0;
	}
}
