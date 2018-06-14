package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GasatIndividualProvider implements Provider<GasatIndividual> {

	private final CNFGeneticMaxSatWrapper wrapper;
	
	@Inject
	public GasatIndividualProvider(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public GasatIndividual get() {
		return new GasatIndividual(this.wrapper);
	}
}
