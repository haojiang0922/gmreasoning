package gr.ntua.softeng.wtt.sat.opt;

import java.util.Collection;

import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.core.problem.ProblemModule;

import com.google.inject.Module;

public interface IOptTaskModuleFactory {

	public ProblemModule createProblemModule();
	public OptimizerModule createOptimizerModule();
	public Collection<Module> createAdditionalModules();
}
