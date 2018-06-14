package gr.ntua.softeng.wtt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.InvalidAssignmentException;
import gr.ntua.softeng.wtt.sat.AndOrTreeEvaluatorStrategy;
import gr.ntua.softeng.wtt.sat.opt.cnf.WTT2CNFTransformer;

public class WebTaskTemplateSATTest {

	private static final String WTT_FILE = "models/test.wtt";
	
	public static void main(String[] args) {
		org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl i = new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl();
		int loops = 1000;
		String file = WTT_FILE;
		if (args != null && args.length == 2) {
			file = args[0];
			loops = Integer.parseInt(args[1]);
		}
		// Load Web Task Template from file
		WTT2CNFTransformer transformer = new WTT2CNFTransformer(file, new AndOrTreeEvaluatorStrategy());
		CNFGeneticMaxSatWrapper cnfWrapper = transformer.getCNFWrapper();
		//System.out.println(cnfWrapper);
		//cnfWrapper.evaluateAssignment(assignment);
				
		boolean eval = false;
		int cntr = 0;
		int cost = 0;
		Integer minCost = null;
		Boolean[] bestAssignment = null;
		ArrayList<String> solutions = new ArrayList<String>();
		do {
			Boolean[] assignment = 
					//testValidAssignment(cntr); loops = 9;
					getRandomAssignment(cnfWrapper.getNumOfAtoms());
			ArrayList<Boolean> a = new ArrayList<>(Arrays.asList(assignment));
			
			try {
				cost = cnfWrapper.evaluateAssignment(a);
				eval = true;
			} catch (InvalidAssignmentException e) {
				eval = false;
			}
			cntr++;
			if (eval) {
				if (!solutions.contains("Cost: " + cost + "\t" + Arrays.toString(assignment))) {
					solutions.add("Cost: " + cost + "\t" + Arrays.toString(assignment));
					if (minCost == null || minCost.intValue() < cost) {
						minCost = cost;
						bestAssignment = Arrays.copyOf(assignment, assignment.length);
					}
				}
			}
		} while (cntr < loops);
		
//		for(int i = 0; i<cnfWrapper.getNumOfAtoms(); i++) {
//			Atom a = cnfWrapper.getAtom(i);
//			System.out.printf("%d - %s\n", a.getId(), a.getGoalNodeKey());
//		}
		
		System.out.println("INTERVALS_"+loops+"\ttime (msec): " + cnfWrapper.getEvaluationTime() 
						+ "\n\tcost: " + minCost 
						+ "\n\tassignment: " + Arrays.toString(bestAssignment));

//		System.out.println("\tSolutions: " + solutions.size());
//		Collections.sort(solutions);
//		for (String sol : solutions) {
//			System.out.println("\t"+sol);
//		}
	}
	
	private static boolean[] testValidAssignment(int cntr) {
		boolean[][] all = { {true, false, true, true, true, true, true, true, true, true, true},
				{true, false, true, true, true, false, true, true, true, true, true},
				{true, true, true, true, true, true, true, true, true, true, true},
				{true, false, true, true, true, true, false, true, true, true, true},
				{true, true, true, true, true, false, true, true, true, true, true},
				{true, true, true, true, true, true, false, true, true, true, true},
				{true, true, false, true, true, false, true, true, true, true, true},
				{true, true, false, true, true, true, false, true, true, true, true},
				{true, true, false, true, true, true, true, true, true, true, true} };

		return all[cntr];
	}

	private static Boolean[] getRandomAssignment(int A) {
		Boolean[] assignment = new Boolean[A];
		Random rand = new Random();
		for (int i=0; i < assignment.length; i++) {
			assignment[i] = rand.nextBoolean();
		}
		return assignment;
	}
}
