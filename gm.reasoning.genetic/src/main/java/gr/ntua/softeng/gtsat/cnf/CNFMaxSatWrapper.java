package gr.ntua.softeng.gtsat.cnf;

import gr.ntua.softeng.gtsat.MaxSATModel;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;

import java.util.Map;

public class CNFMaxSatWrapper extends CNFSatWrapper {
	
	private Map<String,Integer> nodeWeights = null;
	
	public CNFMaxSatWrapper(GoalModelAbstraction goalModel) {
		super(goalModel);
		this.parseNodeWeights(goalModel.getNodeWeights());
		this.nodeWeights = goalModel.getNodeWeights();
	}
	
	private void parseNodeWeights(Map<String,Integer> nodeWeights) {
		for (String nodeKey : nodeWeights.keySet()) {
			int w = nodeWeights.get(nodeKey);
			Literal nodeLiteral = this.createLiteral(nodeKey, false);
			WeightedClause c = new WeightedClause();
			c.setWeight(w);
			c.addLiteral(nodeLiteral);
			this.addClause(c);
		}
	}
	
	public MaxSATModel translateModel(int[] model) {
		Map<String, Boolean> nodeValues = translateDIMACSModel(model);
		int totalCost = 0;
		for (String nodeKey : nodeValues.keySet()) {
			if(nodeValues.get(nodeKey)) {
				int cost = this.nodeWeights.get(nodeKey) != null ? this.nodeWeights.get(nodeKey) : 0;
				totalCost = totalCost + cost;
			}
		}
		return new MaxSATModel(nodeValues, totalCost);
	}
}
