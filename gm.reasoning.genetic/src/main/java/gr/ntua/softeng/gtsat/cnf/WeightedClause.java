package gr.ntua.softeng.gtsat.cnf;

public class WeightedClause extends AbstractClause {

	private int weight = 1;

	@Override
	public boolean isHard() {
		return false;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	} 
}
