package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.Map;

public class MaxSATModel extends SATModel implements IMaxSATModel {

	private Integer totalCost = 0;

	public MaxSATModel(Map<String, Boolean> nodeValues, Map<String, Boolean> leafValues, Integer totalCost) {
		super(nodeValues, leafValues);
		this.totalCost = totalCost;
	}

	//TODO remove this constructor
	public MaxSATModel(Map<String, Boolean> nodeValues, Integer totalCost) {
		super(nodeValues, null);
		this.totalCost = totalCost;
	}
	
	//TODO
	public Integer getTotalCost(boolean dummy) {
		return totalCost;
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
	
	public boolean equals(MaxSATModel o) {
		boolean equal = true;

		if (o == null)
			return false;
		
		if (this.totalCost != o.getTotalCost())
			return false;
		
		if (this.getNodeValues().size() != o.getNodeValues().size())
			return false;
		
		for (String key : this.getNodeValues().keySet()) {
			if (!(o.getNodeValues().get(key).equals(this.getNodeValues().get(key))))
				return false;
		}
		
		return equal;		
	}
}
