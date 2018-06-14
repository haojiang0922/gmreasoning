package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.operators.crossover.CrossoverModule;

public class MyCrossoverModule extends CrossoverModule {

	@Override
	protected void config() {
		this.addOperator(MyCrossover.class);
	}

}
