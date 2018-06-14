package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import org.opt4j.core.AbstractIndividualFactory;
import org.opt4j.core.Genotype;
import org.opt4j.core.problem.Creator;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GasatIndividualFactory extends AbstractIndividualFactory<GasatIndividual> {

	@Inject
	public GasatIndividualFactory(Provider<GasatIndividual> individualProvider, Creator<Genotype> creator) {
		super(individualProvider, creator);
	}

	@Override
	public GasatIndividual create() {
		GasatIndividual individual = individualProvider.get();
		Genotype genotype = creator.create();
		individual.setGenotype(genotype);
		return individual;
	}

	@Override
	public GasatIndividual create(Genotype genotype) {
		GasatIndividual individual = individualProvider.get();
		individual.setGenotype(genotype);
		return individual;
	}
	
	
}
