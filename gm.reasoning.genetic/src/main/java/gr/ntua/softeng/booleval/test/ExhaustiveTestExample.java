package gr.ntua.softeng.booleval.test;

import gr.ntua.softeng.booleval.AndOrTreeEvaluator;
import gr.ntua.softeng.booleval.Evaluation;
import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.AbstractCNFFormulaEvaluator;
import gr.ntua.softeng.gtsat.cnf.eval.IEvaluationStrategy;
import gr.ntua.softeng.wtt.sat.opt.cnf.WTT2CNFTransformer;

import java.util.ArrayList;
import java.util.Arrays;

public class ExhaustiveTestExample {
	
	public static void main(String[] args) {
		CNFGeneticMaxSatWrapper cnfWrapper = null;		
		WTT2CNFTransformer transformer = new WTT2CNFTransformer("test_costs.wtt",new DummyEvaluatorStrategy());
		cnfWrapper = transformer.getCNFWrapper();
		int atomsSize = cnfWrapper.getNumOfAtoms();
		Boolean[][] allAssignments = calcAllAssignments(atomsSize);		
		
		AndOrTreeEvaluator evaluator = new AndOrTreeEvaluator(cnfWrapper);
				
		double totalTime = 0;
		for (int x = 0; x < 100; x++) {
			Evaluation eval = null;
			ArrayList<String> solutions = new ArrayList<String>();
			for (int i = 0; i < allAssignments.length; i++) {
				ArrayList<Boolean> assignment = new ArrayList<>(Arrays.asList(allAssignments[i]));
				eval = evaluator.evaluateAssignment(assignment);
				totalTime += eval.getTime();
				if (eval.getResult()) {
					if (!solutions.contains("Cost: " + eval.getTotalCost() +"\t"+ Arrays.toString(allAssignments[i]))) 
						solutions.add("Cost: " + eval.getTotalCost() +"\t"+ Arrays.toString(allAssignments[i]));
				}
			}
		}
		System.out.println("Took: " + totalTime + " msec to check " + allAssignments.length*1000 + " assignments.");
		System.out.println("Avg per eval: " + (double)(totalTime/(allAssignments.length*1000)));
//		System.out.println("Solutions: " + solutions.size());
//		for (String sol : solutions) {
//			System.out.println(sol);
//		}
	}

private static Boolean[][] calcAllAssignments(int atomsSize) {
		int size = (int)(Math.pow(2, atomsSize));
		Boolean[][] all = new Boolean[size][atomsSize];
		
		for (int i = 0; i < size; i++) {
			String s = Integer.toBinaryString(i);
			while (s.length() < atomsSize) {
				s = "0" + s;
			}
			for (int k = 0; k < atomsSize; k++) {
				all[i][k] = (s.substring(k,k+1).equals("0") ? false : true);
			}			
		}
		
		return all;
	}

//	private static void printTreeStructure(AndOrTree tree) {
//		printSubTree(tree.getRoot(),"-");
//	}
//
//	private static void printSubTree(TreeNode root, String s) {
//		System.out.println(s+"["+(root.getEnd()-root.getBegin()+1)+"]");
//		for (TreeNode o : root.getChildren()) {
//			printSubTree(o,s+"-");
//		}
//	}
	
	private static class DummyEvaluatorStrategy implements IEvaluationStrategy {

		@Override
		public AbstractCNFFormulaEvaluator createEvaluator(
				CNFGeneticMaxSatWrapper wrapper) {
			return null;
		}
		
	}
}
