package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

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

public class ImprovedIndividualHandler implements Creator<BooleanGenotype>,
		Decoder<BooleanGenotype, ArrayList<Boolean>>,
		Evaluator<ArrayList<Boolean>> {

	private Random random = new Random();
	
	private final CNFGeneticMaxSatWrapper wrapper;

	@Inject	
	public ImprovedIndividualHandler(CNFGeneticMaxSatWrapper wrapper) {
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
		return new Objectives();
	}
}
