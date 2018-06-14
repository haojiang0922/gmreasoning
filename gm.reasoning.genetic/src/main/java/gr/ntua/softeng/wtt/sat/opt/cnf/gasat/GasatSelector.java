package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.wtt.sat.opt.IndividualComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.opt4j.core.Individual;
import org.opt4j.core.common.random.Rand;
import org.opt4j.optimizers.ea.SelectorDefault;

import com.google.inject.Inject;

public class GasatSelector extends SelectorDefault {

	private final CNFGeneticMaxSatWrapper wrapper;
	
	@Inject
	public GasatSelector(Rand random, CNFGeneticMaxSatWrapper wrapper) {
		super(random);
		this.wrapper = wrapper;
	}

	/*
	 * (non-Javadoc)
	 * @see org.opt4j.optimizers.ea.Nsga2#getParents(int, java.util.Collection)
	 * Selection algorithm described in :
	 * "GASAT: a genetic local search algorithm for the satisfiability problem"
	 */
	@Override
	public TreeSet<Individual> getParents(int numberOfParents, Collection<Individual> population) {
		IndividualComparator comp = new IndividualComparator();
		ArrayList<Individual> all = new ArrayList<Individual>(population);
		TreeSet<Individual> parents = new TreeSet<Individual>(comp);
		while(parents.size() <= numberOfParents && !all.isEmpty()) {
			// Select randomly one individual from the population
			Individual currentInd = all.remove(this.random.nextInt(all.size()));
			// - If the required number of parents has NOT been reached add the selected individual.
			// - If the required number of parents has been reached check whether current
			//   individual is better that the worst individual in the parents set.
			if(parents.size() < numberOfParents) {
				parents.add(currentInd);
			} else if(comp.compare(currentInd, parents.first()) > 0) {
				Individual old = parents.first();
				parents.remove(old);
				parents.add(currentInd);
			}
		}
		return parents;
	}
	
	@Override
	public Collection<Individual> getLames(int numOfIndividualsToRemove, Collection<Individual> population) {
		IndividualComparator comp = new IndividualComparator();
		ArrayList<Individual> all = new ArrayList<Individual>(population);
		TreeSet<Individual> lames = new TreeSet<Individual>(comp);
		while(lames.size() <= numOfIndividualsToRemove && !all.isEmpty()) {
			// Select randomly one individual from the population
			Individual currentInd = all.remove(this.random.nextInt(all.size()));
			// - If the required number of lames has NOT been reached add the selected individual.
			// - If the required number of lames has been reached check whether current
			//   individual is worst that the better individual in the lames set.
			if(lames.size() < numOfIndividualsToRemove) {
				lames.add(currentInd);
			} else if(comp.compare(currentInd, lames.last()) < 0) {
				Individual old = lames.last();
				lames.remove(old);
				lames.add(currentInd);
			}
		}
		return lames;
	}
	
	@Override
	public List<List<Individual>> fronts(Collection<Individual> arg0) {
		// TODO Auto-generated method stub
		return super.fronts(arg0);
	}

	

	

	@Override
	protected Map<Individual, Integer> getRank(List<List<Individual>> arg0) {
		// TODO Auto-generated method stub
		return super.getRank(arg0);
	}

	@Override
	public void init(int maxsize) {
		// TODO Auto-generated method stub
		super.init(maxsize);
	}

	
	
	
}
