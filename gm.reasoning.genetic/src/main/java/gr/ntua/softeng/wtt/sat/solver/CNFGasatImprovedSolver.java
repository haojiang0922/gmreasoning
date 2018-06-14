package gr.ntua.softeng.wtt.sat.solver;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved.GasatImprovedModuleFactory;

public class CNFGasatImprovedSolver extends CNFEvolutionarySolver {

	public CNFGasatImprovedSolver(String wttFile, int generations) {
		super(wttFile, generations);
	}

	public CNFGasatImprovedSolver(String wttFile, int generations, int populationSize) {
		super(wttFile, generations, populationSize);
	}

	@Override
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		return new GasatImprovedModuleFactory(cnfWrapper, generations);
	}

	@Override
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int populationSize) {
		return new GasatImprovedModuleFactory(cnfWrapper, generations, populationSize);
	}	
}
