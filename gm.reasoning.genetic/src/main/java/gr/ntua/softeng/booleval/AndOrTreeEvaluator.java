package gr.ntua.softeng.booleval;

import gr.ntua.softeng.booleval.andortree.AndOrTree;
import gr.ntua.softeng.booleval.andortree.LeafNode;
import gr.ntua.softeng.booleval.andortree.Operator;
import gr.ntua.softeng.booleval.andortree.OperatorNode;
import gr.ntua.softeng.gtsat.cnf.AbstractClause;
import gr.ntua.softeng.gtsat.cnf.Atom;
import gr.ntua.softeng.gtsat.cnf.CNFFormula;
import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.Literal;
import gr.ntua.softeng.gtsat.cnf.eval.AbstractCNFFormulaEvaluator;

import java.util.ArrayList;
import java.util.HashMap;

public class AndOrTreeEvaluator extends AbstractCNFFormulaEvaluator {

	public double evaluationTime = 0;
	public double treeConstructionTime = 0;
	private AndOrTree tree;
	public AndOrTree getTree() {
		return tree;
	}
	private boolean shouldLog = false;

	private Atom[] atomsArray = null;
	private HashMap<Literal,LeafNode> litleaves = new HashMap<Literal, LeafNode>();
	
	public AndOrTreeEvaluator(CNFGeneticMaxSatWrapper wrapper) {
		super(wrapper);
		long start = System.nanoTime();
		atomsArray = new Atom[wrapper.getNumOfAtoms()];
		tree = constructTree(wrapper.getCNFFormula());
		treeConstructionTime = (double)((System.nanoTime()-start)/1000000d);
		//System.out.println("Intervals: AndOrTree was built & labeled in " + treeConstructionTime + " msec.");
	}
	
	public AndOrTreeEvaluator(AndOrTree t) {
		super(null);
		this.tree = t;
		this.tree.initializeAllTreeNodes();
		this.tree.labelTree();
	}
	
	public double getTreeConstructionTime() {
		return treeConstructionTime;
	}

	private AndOrTree constructTree(CNFFormula f) {
		if (f == null)
			return null;
		
		AndOrTree t = new AndOrTree();
		
		OperatorNode root = new OperatorNode(Operator.OR);
		t.setRoot(root);
		
		OperatorNode cnfAnd = new OperatorNode(Operator.AND);
		root.addChild(cnfAnd);
		
		for (AbstractClause a : f.getClauses())	{
			OperatorNode cnfOr = new OperatorNode(Operator.OR);
			cnfAnd.addChild(cnfOr);

			for (Literal l : a.getLiterals()) {
				LeafNode ln = new LeafNode(l);
				cnfOr.addChild(ln);
				litleaves.put(l, ln);
				atomsArray[l.getId()-1] = l.getAtom();
			}
		}
				
		t.setDepth(3);
		t.initializeAllTreeNodes();
		t.labelTree();
				
		return t;
	}

	@Override
	public boolean checkAssignment(ArrayList<Boolean> assignment) {
		return evaluateAssignment(assignment).getResult();
	}
	
	public Evaluation evaluateAssignment(ArrayList<Boolean> assignment) {
		ArrayList<LeafNode> intervals = new ArrayList<LeafNode>();
		
		for (int i = 0; i < assignment.size(); i++)  {
			Atom atom = atomsArray[i];
			if (assignment.get(i)) {
				for (Literal l : atom.getPositiveLiterals()) {
					intervals.add(litleaves.get(l));
				}				
			}
			else {
				for (Literal l : atom.getNegativeLiterals()) {
					intervals.add(litleaves.get(l));
				}
			}
		}
		Evaluation eval = AndOrTree.match(intervals, tree.getLeaves().size());
		evaluationTime = eval.getTime();
		logEvaluation(eval);
		return eval;
	}
	
	public Evaluation evaluateIntervalsAssignment(ArrayList<LeafNode> intervals) {
		Evaluation eval = AndOrTree.match(intervals, tree.getLeaves().size());
		evaluationTime = eval.getTime();
		logEvaluation(eval);
		return eval;
	}

	private void logEvaluation(Evaluation eval) {
		if (shouldLog) {
			System.out.println(eval);
		}
	}

	@Override
	public double getEvaluationTime() {
		return evaluationTime;
	}
	
	private Atom getAtom(int atomId) {
		return this.getWrapper().getAtom(atomId);
	}
}
