package gr.ntua.softeng.wtt.sat.opt.cnf;


import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

import org.opt4j.core.problem.ProblemModule;

import com.google.inject.Provides;

public class CostOptimizationProblemModule extends ProblemModule {

private final CNFGeneticMaxSatWrapper wrapper;
	
	public CostOptimizationProblemModule(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Provides
	public CNFGeneticMaxSatWrapper getWrapper() {
		return this.wrapper;
	}
	
	@Override
	protected void config() {
		bindProblem(
				IndividualHandler.class, 
				IndividualHandler.class, 
				IndividualHandler.class
		);
	}
}
