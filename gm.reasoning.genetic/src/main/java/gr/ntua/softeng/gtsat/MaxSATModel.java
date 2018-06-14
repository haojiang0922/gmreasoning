package gr.ntua.softeng.gtsat;

import java.util.Map;

public class MaxSATModel extends SATModel {

	private Integer totalCost = 0;

	public MaxSATModel(Map<String, Boolean> nodeValues, Integer totalCost) {
		super(nodeValues);
		this.totalCost = totalCost;
	}

	public Integer getTotalCost() {
		return totalCost;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(super.toString());
		buffer.append("\t").append("cost: ").append(this.totalCost).append("\n");
		return buffer.toString();
	}
}
