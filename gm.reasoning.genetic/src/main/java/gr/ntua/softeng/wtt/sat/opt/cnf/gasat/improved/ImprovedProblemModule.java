package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;


import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

import org.opt4j.core.problem.ProblemModule;

import com.google.inject.Provides;

public class ImprovedProblemModule extends ProblemModule {

private final CNFGeneticMaxSatWrapper wrapper;
	
	public ImprovedProblemModule(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	@Provides
	public CNFGeneticMaxSatWrapper getWrapper() {
		return this.wrapper;
	}
	
	@Override
	protected void config() {
		bindProblem(
				ImprovedIndividualHandler.class, 
				ImprovedIndividualHandler.class, 
				ImprovedIndividualHandler.class
		);
	}
}
