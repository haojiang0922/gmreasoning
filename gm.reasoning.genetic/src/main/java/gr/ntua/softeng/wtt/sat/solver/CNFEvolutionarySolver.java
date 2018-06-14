package gr.ntua.softeng.wtt.sat.solver;

import gr.ntua.softeng.gtsat.MaxSATModel;
import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.InvalidAssignmentException;
import gr.ntua.softeng.wtt.sat.AndOrTreeEvaluatorStrategy;
import gr.ntua.softeng.wtt.sat.opt.CostOptimizationTask;
import gr.ntua.softeng.wtt.sat.opt.EvolutionaryModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.cnf.WTT2CNFTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Individual;
import org.opt4j.core.genotype.BooleanGenotype;
import org.opt4j.core.optimizer.Archive;

public class CNFEvolutionarySolver extends IWTTMaxSatSolver {

	private MaxSATModel model = null;
	private double time = 0;
	private CNFGeneticMaxSatWrapper cnfWrapper;
	
	public CNFEvolutionarySolver(String wttFile, int generations) {
		WTT2CNFTransformer transformer = new WTT2CNFTransformer(wttFile, new AndOrTreeEvaluatorStrategy());
		this.cnfWrapper = transformer.getCNFWrapper();
		IOptTaskModuleFactory moduleFactory = createFactory(this.cnfWrapper, generations);
		this.executeTask(moduleFactory);
	}
	
	public CNFEvolutionarySolver(String wttFile, int generations, int populationSize) {
		WTT2CNFTransformer transformer = new WTT2CNFTransformer(wttFile, new AndOrTreeEvaluatorStrategy());
		this.cnfWrapper = transformer.getCNFWrapper();
		IOptTaskModuleFactory moduleFactory = createFactory(this.cnfWrapper, generations, populationSize);
		this.executeTask(moduleFactory);
	}
	
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations) {
		return new EvolutionaryModuleFactory(cnfWrapper, generations);
	}
	
	protected IOptTaskModuleFactory createFactory(CNFGeneticMaxSatWrapper cnfWrapper, int generations, int populationSize) {
		return new EvolutionaryModuleFactory(cnfWrapper, generations, populationSize);
	}

	private void executeTask(IOptTaskModuleFactory moduleFactory) {
		CostOptimizationTask task = new CostOptimizationTask(moduleFactory);
		try {
			long start = System.nanoTime();
			System.out.println("Going to execute...");
	        task.execute();
	        System.out.println("execution complete.");
	        Archive archive = task.getInstance(Archive.class);
	        for (Individual individual : archive) {
	        	if ( individual.getGenotype() instanceof BooleanGenotype) {
	        		BooleanGenotype bg = (BooleanGenotype)individual.getGenotype();
	        		try {
	        			int cost = this.cnfWrapper.evaluateAssignment(bg);
	        			Map<String,Boolean> valuesMap = assignment2ValuesMap(bg);
			        	model = new MaxSATModel(valuesMap, cost);
	        		} catch (InvalidAssignmentException e) {
	        			model = null;
	        		}
	        	}
	        }
	        this.time = (double)(System.nanoTime() - start)/1000000.0;
		} catch (Exception e) {
	        e.printStackTrace();
		} finally {
	        task.close();
		} 
	}
	
	private Map<String,Boolean> assignment2ValuesMap(ArrayList<Boolean> assignment) {
		Map<String,Boolean> valuesMap = new HashMap<String,Boolean>();
		for(int i = 0; i < assignment.size(); i++) {
			String nodeKey = cnfWrapper.getAtom(i).getGoalNodeKey();
			Boolean value = assignment.get(i);
			valuesMap.put(nodeKey, value);
		}
		return valuesMap;
	}
	
	@Override
	public MaxSATModel getModel() {
		return this.model;
	}

	@Override
	public double getTimeInMillis() {
		return this.time;
	}

}
