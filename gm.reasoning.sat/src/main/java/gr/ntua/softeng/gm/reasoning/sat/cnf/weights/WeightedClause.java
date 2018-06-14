package gr.ntua.softeng.gm.reasoning.sat.cnf.weights;

import gr.ntua.softeng.gm.reasoning.sat.cnf.Clause;

public class WeightedClause extends Clause {

	private int weight = 0;
	
	@Override
	public boolean isHard() {
		return weight == 0;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	} 
}
