package gr.ntua.softeng.wtt.sat.opt;

import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.core.problem.ProblemModule;
import org.opt4j.core.start.Opt4JTask;

import com.google.inject.Module;

public class CostOptimizationTask extends Opt4JTask {

	public CostOptimizationTask(IOptTaskModuleFactory moduleFactory) {
		super(false);
		Collection<Module> modules = new ArrayList<Module>();
		// Problem Module
		ProblemModule problemModule = moduleFactory.createProblemModule();
		modules.add(problemModule);
		// Optimizer Module
		OptimizerModule optimizerModule = moduleFactory.createOptimizerModule();
		modules.add(optimizerModule);
		// Additional Modules
		modules.addAll(moduleFactory.createAdditionalModules());
		this.init(modules);
	}
}
