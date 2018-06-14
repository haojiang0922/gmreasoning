package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.EvolutionaryModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithmModule;

import com.google.inject.Module;

public class GasatModuleFactory extends EvolutionaryModuleFactory implements IOptTaskModuleFactory {

	public GasatModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		super(cnfWrapper, generations);
	}

	public GasatModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int populationSize) {
		super(cnfWrapper, generations, populationSize);
	}
	
	@Override
	public OptimizerModule createOptimizerModule() {
		EvolutionaryAlgorithmModule optimizerModule = new GasatOptimizerModule();
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
