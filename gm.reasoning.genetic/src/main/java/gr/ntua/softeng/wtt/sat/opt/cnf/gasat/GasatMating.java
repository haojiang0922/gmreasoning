package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.core.Genotype;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.common.random.Rand;
import org.opt4j.operators.copy.Copy;
import org.opt4j.operators.crossover.Crossover;
import org.opt4j.operators.mutate.Mutate;
import org.opt4j.operators.mutate.MutationRate;
import org.opt4j.optimizers.ea.Coupler;
import org.opt4j.optimizers.ea.CrossoverRate;
import org.opt4j.optimizers.ea.MatingCrossoverMutate;

import com.google.inject.Inject;

public class GasatMating extends MatingCrossoverMutate {

	@Inject
	public GasatMating(Crossover<Genotype> crossover, Mutate<Genotype> mutate,
			Copy<Genotype> copy, Coupler coupler, CrossoverRate crossoverRate,
			MutationRate mutationRate, Rand random,
			IndividualFactory individualFactory) {
		super(crossover, mutate, copy, coupler, crossoverRate, mutationRate, random,
				individualFactory);
		System.out.println("Inside my mating");
		System.out.println("Coupler : " + coupler.getClass().getName());
		System.out.println("crossover :" + crossover.getClass().getName());
	}
}
