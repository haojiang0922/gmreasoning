package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.optimizers.ea.Coupler;
import org.opt4j.optimizers.ea.CouplerRandom;
import org.opt4j.optimizers.ea.Mating;
import org.opt4j.optimizers.ea.MatingModule;

public class GasatMatingModule extends MatingModule {

	@Override
	protected void config() {
		bind(Mating.class).to(GasatMating.class);
		bind(Coupler.class).to(CouplerRandom.class);
	}
}
