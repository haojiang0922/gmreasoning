package gr.ntua.softeng.gm.model.impl.ext;

public class WeightedNodeData {

	private Double weight;
	private boolean isInverse;
	
	public WeightedNodeData(Double weight, boolean isInverse) {
		super();
		this.weight = weight;
		this.isInverse = isInverse;
	}
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public boolean isInverse() {
		return isInverse;
	}
	public void setInverse(boolean isInverse) {
		this.isInverse = isInverse;
	}	
	
}
