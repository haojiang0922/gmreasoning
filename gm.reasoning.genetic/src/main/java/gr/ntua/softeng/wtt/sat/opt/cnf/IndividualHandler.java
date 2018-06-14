package gr.ntua.softeng.wtt.sat.opt.cnf;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.InvalidAssignmentException;

import java.util.ArrayList;
import java.util.Random;

import org.opt4j.core.Objectives;
import org.opt4j.core.genotype.BooleanGenotype;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Evaluator;

import com.google.inject.Inject;

public class IndividualHandler implements Creator<BooleanGenotype>,
		Decoder<BooleanGenotype, ArrayList<Boolean>>,
		Evaluator<ArrayList<Boolean>> {

	private Random random = new Random();
	
	private final CNFGeneticMaxSatWrapper wrapper;

	@Inject	
	public IndividualHandler(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Override
	public BooleanGenotype create() {
		BooleanGenotype genotype = new BooleanGenotype();
		genotype.init(random, this.wrapper.getNumOfAtoms());
		return genotype;
	}
	
	@Override
	public ArrayList<Boolean> decode(BooleanGenotype genotype) {
		return genotype;
	}
	
	@Override
	public Objectives evaluate(ArrayList<Boolean> phenotype) {
		Integer cost = null;
		Integer numOfFalseClauses = null;
		try {
			cost = wrapper.evaluateAssignment(phenotype);
			numOfFalseClauses = 0;
		} catch (InvalidAssignmentException e) {
			cost = wrapper.evaluateAssignmentCost(phenotype);
			numOfFalseClauses = wrapper.evaluateAssignment2(phenotype);
		}
		return new CostObjectives(cost, numOfFalseClauses);
	}
}
