package gr.ntua.softeng.wtt.sat.solver;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatModuleFactory;

public class CNFGasatSolver extends CNFEvolutionarySolver {

	public CNFGasatSolver(String wttFile, int generations) {
		super(wttFile, generations);
	}

	public CNFGasatSolver(String wttFile, int generations, int populationSize) {
		super(wttFile, generations, populationSize);
	}

	@Override
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		return new GasatModuleFactory(cnfWrapper, generations);
	}

	@Override
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int populationSize) {
		return new GasatModuleFactory(cnfWrapper, generations, populationSize);
	}	
}
