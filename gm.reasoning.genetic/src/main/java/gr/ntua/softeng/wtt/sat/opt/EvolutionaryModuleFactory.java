package gr.ntua.softeng.wtt.sat.opt;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.cnf.CostOptimizationProblemModule;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.core.problem.ProblemModule;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithmModule;

import com.google.inject.Module;

public class EvolutionaryModuleFactory implements IOptTaskModuleFactory {

	protected int generations = 0;
	protected int populationSize = 0;
	protected CNFGeneticMaxSatWrapper cnfWrapper;
	
	public EvolutionaryModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int poppulationSize) {
		this.generations = generations;
		this.populationSize = poppulationSize;
		this.cnfWrapper = cnfWrapper;
	}
	
	public EvolutionaryModuleFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		this.generations = generations;
		this.cnfWrapper = cnfWrapper;
	}
	
	@Override
	public ProblemModule createProblemModule() {
		return new CostOptimizationProblemModule(this.cnfWrapper);
	}

	@Override
	public OptimizerModule createOptimizerModule() {
		EvolutionaryAlgorithmModule optimizerModule = new EvolutionaryAlgorithmModule();
		optimizerModule.setGenerations(this.generations);
		if (populationSize > 0) optimizerModule.setAlpha(this.populationSize);
		return optimizerModule;
	}

	@Override
	public Collection<Module> createAdditionalModules() {
		return new ArrayList<Module>();
	}
}
