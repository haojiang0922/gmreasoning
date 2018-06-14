package gr.ntua.softeng.wtt.test;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.InvalidAssignmentException;
import gr.ntua.softeng.wtt.sat.AndOrTreeEvaluatorStrategy;
import gr.ntua.softeng.wtt.sat.opt.CostOptimizationTask;
import gr.ntua.softeng.wtt.sat.opt.EvolutionaryModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.IOptTaskModuleFactory;
import gr.ntua.softeng.wtt.sat.opt.cnf.WTT2CNFTransformer;
import gr.ntua.softeng.wtt.sat.opt.cnf.gasat.GasatModuleFactory;

import java.util.ArrayList;

import org.opt4j.core.Individual;
import org.opt4j.core.genotype.BooleanGenotype;
import org.opt4j.core.optimizer.Archive;

public class OptimizationTest {

	private static final String WTT_FILE = "models/random/WTT_1383662188915.wtt";//"test_costs.wtt";
	
	public static void main(String[] args) {
		// Load Web Task Template from file
		WTT2CNFTransformer transformer = new WTT2CNFTransformer(WTT_FILE, new AndOrTreeEvaluatorStrategy());
		CNFGeneticMaxSatWrapper cnfWrapper = transformer.getCNFWrapper();
		
		//IOptTaskModuleFactory moduleFactory = new EvolutionaryModuleFactory(cnfWrapper, 1000);
		IOptTaskModuleFactory moduleFactory = new GasatModuleFactory(cnfWrapper, 1000);
		CostOptimizationTask task = new CostOptimizationTask(moduleFactory);
		try {
				long start = System.currentTimeMillis();
		        task.execute();
		        long end = System.currentTimeMillis();
		        System.out.println("Time = " + (end-start));
		        Archive archive = task.getInstance(Archive.class);
		        for (Individual individual : archive) {
		        	System.out.println("New Individual...");
		        	if ( individual.getGenotype() instanceof BooleanGenotype) {
		        		BooleanGenotype bg = (BooleanGenotype)individual.getGenotype();
		        		try {
		        			int cost = cnfWrapper.evaluateAssignment(bg);
				        	System.out.println("OPT-MAXSAT\ttime (msec): "+ (double)(System.nanoTime() - start)/1000000.0 
				    				+ "\n\tcost: " + cost  
				    				+ "\n\tassignment: " + assignment2String(bg, cnfWrapper));
		        		} catch (InvalidAssignmentException e) {
		        			System.out.println("Invalid assignment!");
		        			System.out.println("OPT-MAXSAT\ttime (msec): "+ (double)(System.nanoTime() - start)/1000000.0 
				    				+ "\n\tassignment: " + assignment2String(bg, cnfWrapper));
		        		}
		        	}
		        }
		} catch (Exception e) {
		        e.printStackTrace();
		} finally {
		        task.close();
		} 
	}
	
	private static String assignment2String(ArrayList<Boolean> assignment, CNFGeneticMaxSatWrapper cnfWrapper) {
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < assignment.size(); i++) {
			String nodeKey = cnfWrapper.getAtom(i).getGoalNodeKey();
			Boolean value = assignment.get(i);
			buffer.append(nodeKey).append(" = ").append(value).append("\n");
		}
		return buffer.toString();
	}
}
