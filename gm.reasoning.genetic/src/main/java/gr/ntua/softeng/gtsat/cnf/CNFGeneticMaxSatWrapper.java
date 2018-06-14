package gr.ntua.softeng.gtsat.cnf;

import gr.ntua.softeng.gtsat.cnf.eval.AbstractCNFFormulaEvaluator;
import gr.ntua.softeng.gtsat.cnf.eval.IEvaluationStrategy;
import gr.ntua.softeng.gtsat.cnf.eval.InvalidAssignmentException;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CNFGeneticMaxSatWrapper extends CNFSatWrapper {

	private Atom[] atoms = null;
	private Integer[] weights = null;
	private double evaluationTime = 0;
	
	private AbstractCNFFormulaEvaluator evaluator = null;
	
	public CNFGeneticMaxSatWrapper(GoalModelAbstraction goalModel, IEvaluationStrategy evalStrategy) {
		super(goalModel);
		this.initializeAtomsAndWeigths(goalModel.getNodeWeights());
		this.evaluator = evalStrategy.createEvaluator(this);
	}
	
	private void initializeAtomsAndWeigths(Map<String,Integer> nodeWeights) {
		int numOfAtoms = this.getNumOfAtoms();
		atoms = new Atom[numOfAtoms];
		weights = new Integer[numOfAtoms];
		for(int i=0; i<numOfAtoms; i++) {
			String atomKey = this.getNodeKeyFromAtomId(i+1);
			atoms[i] = this.getAtomFromNodeKey(atomKey);
			weights[i] = nodeWeights.get(atomKey);
		}
	}
	
	public Atom getAtom(int i) {
		return this.atoms[i];
	}
	
	public Integer getWeight(int i) {
		return this.weights[i];
	}
	
	public void setWeight(String nodeKey, Integer w) {
		Atom a = this.getAtomFromNodeKey(nodeKey);
		Integer id = a.getId();
		this.weights[id-1] = w;
	}
	
	public Integer evaluateAssignment(ArrayList<Boolean> assignment) throws InvalidAssignmentException {
		Integer totalWeight = 0;
		int currentWeight;
		if(this.evaluator.checkAssignment(assignment)) {
			for(int i=0; i<assignment.size(); i++) {
				if(assignment.get(i)) {
					currentWeight = this.getWeight(i) == null ? 0 : this.getWeight(i).intValue();
					totalWeight += currentWeight;
				}
			} 
			evaluationTime += evaluator.getEvaluationTime();
		} else {
			evaluationTime += evaluator.getEvaluationTime();
			throw new InvalidAssignmentException();
		}
		return totalWeight;
	}
	
	public Integer evaluateAssignmentCost(ArrayList<Boolean> assignment) {
		Integer totalWeight = 0;
		int currentWeight;
		for(int i=0; i<assignment.size(); i++) {
			if(assignment.get(i)) {
				currentWeight = this.getWeight(i) == null ? 0 : this.getWeight(i).intValue();
				totalWeight += currentWeight;
			}
		} 
		return totalWeight;
	}
	
	public Integer evaluateAssignment2(ArrayList<Boolean> assignment) {
		Set<AbstractClause> negatedClauses = new HashSet<AbstractClause>(this.getClauses());
		for(int i=0; i<assignment.size(); i++) {
			if(assignment.get(i)) {
				negatedClauses.removeAll(this.getAtom(i).getPositiveClauses());
			}
		}
		return negatedClauses.size();
	}
	
	public boolean checkAssignment(ArrayList<Boolean> assignment) {
		return this.evaluator.checkAssignment(assignment);
	}
	
	public double getEvaluationTime() {
		return evaluationTime;
	}

}
