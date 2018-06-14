package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatOptimizerModule;

import org.opt4j.core.IndividualFactory;

public class GasatImprovedOptimizerModule extends GasatOptimizerModule {
		
	@Override
	public void config() {
		super.config();
		bind(IndividualFactory.class).to(GasatIndividualFactory.class);
		bind(GasatIndividual.class).toProvider(GasatIndividualProvider.class);
	}
}
