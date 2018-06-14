package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.EvolutionaryModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.cnf.CostOptimizationProblemModule;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatMatingModule;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatSelectorModule;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.MyCrossoverModule;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.core.problem.ProblemModule;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithmModule;

import com.google.inject.Module;

public class GasatImprovedModuleFactory extends EvolutionaryModuleFactory implements IOptTaskModuleFactory {

	public GasatImprovedModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		super(cnfWrapper, generations);
	}

	public GasatImprovedModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int populationSize) {
		super(cnfWrapper, generations, populationSize);
	}
	
	@Override
	public ProblemModule createProblemModule() {
		return new ImprovedProblemModule(this.cnfWrapper);
	}
	
	@Override
	public OptimizerModule createOptimizerModule() {
		EvolutionaryAlgorithmModule optimizerModule = new GasatImprovedOptimizerModule();
		optimizerModule.setGenerations(this.generations);
		return optimizerModule;
	}

	@Override
	public Collection<Module> createAdditionalModules() {
		Collection<Module> additionalModules = new ArrayList<Module>();
		// Selector Module
		additionalModules.add(new GasatSelectorModule());
		// Mating Module
		additionalModules.add(new GasatMatingModule());
		additionalModules.add(new MyCrossoverModule());
		
		return additionalModules;
	}
}
