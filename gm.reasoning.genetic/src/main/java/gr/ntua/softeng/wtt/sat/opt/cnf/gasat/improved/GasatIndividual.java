package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

import org.opt4j.core.Genotype;
import org.opt4j.core.Individual;
import org.opt4j.core.genotype.BooleanGenotype;

public class GasatIndividual extends Individual implements Comparable<GasatIndividual>{

	private final CNFGeneticMaxSatWrapper wrapper;
	private int cost;
	private int numOfFalseClauses;
	
	public GasatIndividual(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Override
	public void setGenotype(Genotype genotype) {
		super.setGenotype(genotype);
		this.cost = this.wrapper.evaluateAssignmentCost((BooleanGenotype)genotype);
		this.numOfFalseClauses = this.wrapper.evaluateAssignment2((BooleanGenotype)genotype);
	}

	@Override
	public int compareTo(GasatIndividual individual) {
		int cost1 = this.getCost();
		int numOfFalse1 = this.getNumOfFalseClauses();
		int cost2 = individual.getCost();
		int numOfFalse2 = individual.getNumOfFalseClauses();
		//
		if (this.getGenotype().equals(individual.getGenotype())) {
			return 0;
		}
		int expression = numOfFalse2 - numOfFalse1;
		if (expression==0) {
			expression = cost1 - cost2;
		}
		if (expression==0) {
			expression = 1;
		}
		return expression;
	}

	public int getCost() {
		return cost;
	}

	public int getNumOfFalseClauses() {
		return numOfFalseClauses;
	}
}
