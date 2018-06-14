package gr.ntua.softeng.booleval.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import gr.ntua.softeng.booleval.AndOrTreeEvaluator;
import gr.ntua.softeng.booleval.Evaluation;
import gr.ntua.softeng.booleval.andortree.AndOrTree;
import gr.ntua.softeng.booleval.andortree.LeafNode;

public class ScalabilityTest {

	/**
	 * Tests whether the implementation of INTERVALS algorithm 
	 * runs in linear time wrt to # of intervals supplied.
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
			PrintWriter writer = new PrintWriter("scalability.log", "UTF-8");
			AndOrTree tree = RandomTreeGenerator.generateAndOrTree(4, 400, 800);
			AndOrTreeEvaluator evaluator = new AndOrTreeEvaluator(tree);
			int loops = 10000;
			int leavesCnt = tree.getLeaves().size();
			double totalTime = 0;
			for (int l = 1; l<= leavesCnt; l++) {
				totalTime = 0;
				for (int j = 0; j < loops; j++) {
					ArrayList<LeafNode> intervals = new ArrayList<LeafNode>();
					boolean[] assignment = getRandomAssignmentForNTrue(leavesCnt,l);
					for (int k = 0; k < leavesCnt; k++) {
						if (assignment[k]) {
							intervals.add(tree.getLeaves().get(k));
						}
					}
					Evaluation eval = evaluator.evaluateIntervalsAssignment(intervals);
					totalTime += eval.getTime();
				}
				totalTime = totalTime / loops;
				writer.println("Depth:\t" + tree.getDepth() +
						"\tOperators:\t" + tree.getOperatorsCnt() +
						"\tLeaves:\t" + tree.getLeavesCnt() +
						"\tIntervals:\t" + l + 
						"\tTime:\t" + totalTime 
									);
				writer.flush();
			}
			writer.close();
	}
	
	private static boolean[] getRandomAssignmentForNTrue(int A, int n) {
		boolean[] assignment = new boolean[A];
		Random rand = new Random();
		Arrays.fill(assignment, false);
		for (int i=0; i < n; i++) {
			int picked = rand.nextInt(A);
			while (assignment[picked]) {
				picked = rand.nextInt(A);
			}
			assignment[picked] = true;
		}
		return assignment;
	}
}
