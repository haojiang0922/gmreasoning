package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import gr.ntua.softeng.wtt.sat.opt.IndividualComparator;

import java.util.Collection;
import java.util.TreeSet;

import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.start.Constant;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithm;
import org.opt4j.optimizers.ea.Mating;

import com.google.inject.Inject;

public class GasatOptimizer extends EvolutionaryAlgorithm {

	private final Population population;
	private final IndividualFactory individualFactory;
	private final IndividualCompleter completer;
	private final GasatSelector selector;
	private IndividualComparator comparator = new IndividualComparator();
	
	@Inject
	public GasatOptimizer(
			Population population,
			IndividualFactory individualFactory,
			IndividualCompleter completer,
			GasatSelector selector,
			Mating mating,
			@Constant(value = "alpha", namespace = EvolutionaryAlgorithm.class) int alpha,
			@Constant(value = "mu", namespace = EvolutionaryAlgorithm.class) int mu,
			@Constant(value = "lambda", namespace = EvolutionaryAlgorithm.class) int lambda) 
	{
		super(population, individualFactory, completer, selector, mating, alpha, mu, lambda);
		this.population = population;
		this.selector = selector;
		this.individualFactory = individualFactory;
		this.completer = completer;
		System.out.println("Mating : " + mating.getClass().getName());
		System.out.println("Completer : " + this.completer.getClass().getName());
		System.out.println("Factory : " + this.individualFactory.getClass().getName());
	}

	@Override
	public void initialize() {
		// Create the initial population
		while (population.size() < alpha) {
			population.add(individualFactory.create());
		}
		super.initialize();
	}

	@Override
	public void next() throws TerminationException {
		long t1 = System.nanoTime();
		// remove lames
		if (population.size() > alpha) {
			Collection<Individual> lames = selector.getLames(population.size() - alpha, population);
			population.removeAll(lames);
		}
		long t2 = System.nanoTime();
		// Parents selection
		TreeSet<Individual> parents = this.selector.getParents(mu, population);
		long t3 = System.nanoTime();
		// Offspring generation
		Collection<Individual> offspring = mating.getOffspring(lambda, parents);
		long t4 = System.nanoTime();
		completer.complete(offspring);
		long t5 = System.nanoTime();
		// Add offsprings
		Individual worstParent = parents.first();
		for (Individual child : offspring) {
			if (comparator.compare(child, worstParent) > 0) {
				population.add(child);
			}
		}
		long t6 = System.nanoTime();
		
		GasatTimer.addRemoveLamesTime(t2 - t1);
		GasatTimer.addSelectionTime(t3 - t2);
		GasatTimer.addMatingTime(t4 - t3);
		GasatTimer.addOffsringTime(t5 - t4);
		GasatTimer.addOffsringSelectionTime(t6 - t5);
		GasatTimer.addTotalTime(t6 - t1);
	}
}
