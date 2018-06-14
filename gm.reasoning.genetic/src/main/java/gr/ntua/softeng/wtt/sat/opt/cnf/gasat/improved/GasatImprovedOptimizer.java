package gr.ntua.softeng.wtt.sat.opt.cnf.gasat.improved;

import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatSelector;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatTimer;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.start.Constant;
import org.opt4j.optimizers.ea.EvolutionaryAlgorithm;
import org.opt4j.optimizers.ea.Mating;

import com.google.inject.Inject;

public class GasatImprovedOptimizer extends EvolutionaryAlgorithm {

	private final TreeSet<GasatIndividual> population;
	private final GasatIndividualFactory individualFactory;
	private final IndividualCompleter completer;
	
	@Inject
	public GasatImprovedOptimizer(
			Population population,
			GasatIndividualFactory individualFactory,
			IndividualCompleter completer,
			GasatSelector selector,
			Mating mating,
			@Constant(value = "alpha", namespace = EvolutionaryAlgorithm.class) int alpha,
			@Constant(value = "mu", namespace = EvolutionaryAlgorithm.class) int mu,
			@Constant(value = "lambda", namespace = EvolutionaryAlgorithm.class) int lambda) 
	{
		super(population, individualFactory, completer, selector, mating, alpha, mu, lambda);
		this.population = new TreeSet<GasatIndividual>();
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
		//super.initialize();
	}

	@Override
	public void next() throws TerminationException {
		long t1 = System.nanoTime();
		// remove lames
		while (population.size() > alpha) {
			population.pollFirst();
		}
		long t2 = System.nanoTime();
		// Parents selection
		Iterator<GasatIndividual> populationIter = population.descendingIterator();
		int numOfParents = mu;
		TreeSet<Individual> parents = new TreeSet<Individual>();
		GasatIndividual worstParent = null;
		while (populationIter.hasNext() && numOfParents>0) {
			GasatIndividual individual = (GasatIndividual) populationIter.next();
			parents.add(individual);
			worstParent = individual;
			numOfParents--;
		}
		long t3 = System.nanoTime();
		// Offspring generation
		Collection<Individual> offspring = mating.getOffspring(lambda, parents);
		long t4 = System.nanoTime();
		//completer.complete(offspring);
		long t5 = System.nanoTime();
		// Add offsprings
		for (Individual child : offspring) {
			if (((GasatIndividual)child).compareTo(worstParent) > 0) {
				population.add((GasatIndividual)child);
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
