package gr.ntua.softeng.gm.reasoning.sat.cnf.weights;

import gr.ntua.softeng.gm.model.GoalModelAbstraction;
import gr.ntua.softeng.gm.model.ObservableWeights;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Atom;
import gr.ntua.softeng.gm.reasoning.sat.cnf.Literal;
import gr.ntua.softeng.gm.reasoning.sat.cnf.SatCNFWrapper;
import gr.ntua.softeng.gr.reasoning.sat.solver.IMaxSATModel;
import gr.ntua.softeng.gr.reasoning.sat.solver.MaxSATModel;
import gr.ntua.softeng.gr.reasoning.sat.solver.MaxSatCNFFormula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSatCNFWrapper<
								A extends Atom, 
								L extends Literal, 
								C extends WeightedClause
							> extends SatCNFWrapper<A, L, C> implements MaxSatCNFFormula {

	protected ObservableWeights nodeWeights = null;
	
	private ArrayList<C> softClauses = new ArrayList<>();
	
	public MaxSatCNFWrapper(GoalModelAbstraction goalModel, MaxSatCNFComponentFactory<A,L,C> factory) {
		super(goalModel, factory);
		this.parseNodeWeights(goalModel.getNodeWeights());
		this.nodeWeights = goalModel.getNodeWeights();
	}
	
	private void parseNodeWeights(ObservableWeights nodeWeights) {
		for (String nodeKey : nodeWeights.nodeKeySet()) {
			int w = nodeWeights.getNodeWeight(nodeKey);
			L nodeLiteral = this.createLiteral(nodeKey, false);
			C c = this.createClause();
			c.setWeight(w);
			c.addLiteral(nodeLiteral);
			this.softClauses.add(c);
		}
	}
	
	public IMaxSATModel translateModel(int[] model) {
		Map<String, Boolean> nodeValues = new HashMap<>();
		Map<String, Boolean> leafValues = new HashMap<>();
		translateDIMACSModel(model, nodeValues, leafValues);
		int totalCost = 0;
		for (String nodeKey : nodeValues.keySet()) {
			if(nodeValues.get(nodeKey)) {
				int cost = this.nodeWeights.getNodeWeight(nodeKey) != null ? this.nodeWeights.getNodeWeight(nodeKey) : 0;
				totalCost = totalCost + cost;
			}
		}
		return new MaxSATModel(nodeValues, leafValues, totalCost);
	}
	
	@Override
	public List<int[]> getHardClausesInDIMACS() {
		return super.getClausesInDIMACS();
	}

	@Override
	public Map<int[], Integer> getSoftClausesInDIMACS() {
		Map<int[], Integer> softClausesMap = new HashMap<int[], Integer>();
		for (C sc : this.softClauses) {
			int[] dimacs = sc.getDIMACSFormat();
			Integer weight = sc.getWeight();
			softClausesMap.put(dimacs, weight);
		}
		return softClausesMap;
	}
	
	protected Integer getWeight(C clause) {
		return clause.getWeight();
	}
	
	public int getNumOfClauses() {
		return super.getNumOfClauses() + this.softClauses.size();
	}
	
	public int getNumOfLiterals() {
		return super.getNumOfLiterals() + this.softClauses.size();
	}
}
