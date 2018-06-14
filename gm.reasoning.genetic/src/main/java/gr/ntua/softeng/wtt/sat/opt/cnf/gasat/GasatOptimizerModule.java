package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.optimizers.ea.ConstantCrossoverRate;
import org.opt4j.optimizers.ea.CrossoverRate;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithmModule;

public class GasatOptimizerModule extends EvolutionaryAlgorithmModule {
		
	@Override
	public void config() {
		bindIterativeOptimizer(GasatOptimizer.class);
		bind(CrossoverRate.class).to(ConstantCrossoverRate.class).in(SINGLETON);
	}
}
