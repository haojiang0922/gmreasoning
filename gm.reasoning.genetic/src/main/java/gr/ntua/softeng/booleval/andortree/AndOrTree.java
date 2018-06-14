package gr.ntua.softeng.booleval.andortree;

import gr.ntua.softeng.booleval.Evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class AndOrTree {

	private OperatorNode root;
	private ArrayList<LeafNode> leaves = new ArrayList<LeafNode>();
	private int depth = 0;
	private int operatorsCnt;
	private int leavesCnt;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getOperatorsCnt() {
		return operatorsCnt;
	}

	public void setOperatorsCnt(int operatorsCnt) {
		this.operatorsCnt = operatorsCnt;
	}

	public ArrayList<LeafNode> getLeaves() {
		return leaves;
	}

	public void setLeaves(ArrayList<LeafNode> leaves) {
		this.leaves = leaves;
	}

	public int getLeftLeavesCnt() {
		return leftLeavesCnt;
	}

	public void setLeftLeavesCnt(int leftLeavesCnt) {
		this.leftLeavesCnt = leftLeavesCnt;
	}

	public OperatorNode getRoot() {
		return root;
	}

	public void setRoot(OperatorNode root) {
		this.root = root;
	}
	
	public ArrayList<TreeNode> initializeAllTreeNodes() {
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		traverseAllNodeChildren(root,nodes);
		root.setBegin(1);
		root.setEnd(leaves.size());
		return nodes;
	}
	private int leftLeavesCnt = 0;
	public int getLeavesCnt() {
		return leavesCnt;
	}

	public void setLeavesCnt(int leavesCnt) {
		this.leavesCnt = leavesCnt;
	}

	private int traverseAllNodeChildren(TreeNode parent, ArrayList<TreeNode> nodes) {
		nodes.add(parent);		
		if (parent instanceof LeafNode) {
			leaves.add((LeafNode)parent);
			leftLeavesCnt++;
			return 1;
		}
		int children = 0;
		for (TreeNode child : parent.getChildren()) {
			child.setLeftLeaves(leftLeavesCnt);
			traverseAllNodeChildren(child, nodes);
			children += child.getSize();
		}
		parent.setSize(children);
		return parent.getChildren().size();
	}

	
	public void labelTree() {
		label(root);
	}
	
	private static void label(TreeNode n) {
		if (n instanceof LeafNode)
			return;
		if (((OperatorNode)n).getOperator().equals(Operator.OR)) {
			for (TreeNode c : n.getChildren()) {
				c.setBegin(n.getBegin());
				c.setEnd(n.getEnd());
				label(c);
			}
		}
		else if (((OperatorNode)n).getOperator().equals(Operator.AND)) {
			TreeNode first = n.getChildren().get(0);
			first.setBegin(n.getBegin());
			first.setEnd(n.getLeftLeaves() + first.getSize());
			if (n.getChildren().size() == 1)
				first.setEnd(n.getEnd());
			label(first);
			int curr = first.getEnd() + 1;
			if (n.getChildren().size() > 2) {
				for (int i = 1; i < n.getChildren().size() - 1; i++) {
					TreeNode tn = n.getChildren().get(i);
					tn.setBegin(curr);
					tn.setEnd(curr + tn.getSize() - 1);
					label(tn);
					curr = tn.getEnd() + 1;
				}
			}
			if (n.getChildren().size() > 1) {
				TreeNode last = n.getChildren().get(n.getChildren().size()-1);
				last.setBegin(curr);
				last.setEnd(n.getEnd());
				label(last);
			}
		}
	}
	
	public static Evaluation match(ArrayList<LeafNode> intervals, int M) {
		long start = System.nanoTime();//currentTimeMillis();
		double minCost = 0;
		double totalCost = 0;
		Collections.sort(intervals, new Comparator<LeafNode>() {
			@Override
			public int compare(LeafNode o1, LeafNode o2) {
				if (o1.getBegin() > o2.getBegin())
					return 1;
				else if (o1.getBegin() < o2.getBegin())
					return -1;
				else if (o1.getEnd() > o2.getEnd())
					return -1;
				else if (o1.getEnd() < o2.getEnd())
					return 1;
				return 0;
			}			
		});
		
		boolean[] matched = new boolean[M+1];
		Arrays.fill(matched, false);
		
		matched[0] = true;
		
		ArrayList<LeafNode> usedLeaves = new ArrayList<LeafNode>();

		for (LeafNode l : intervals) {
			if (matched[l.getBegin()-1]) {
				matched[l.getEnd()] = true;
				minCost += l.getCost();
				usedLeaves.add(l);
			}
			if (matched[M])
				break;
		}
		Evaluation eval = new Evaluation(matched[M],(double)((System.nanoTime()-start)/1000000d),minCost,0);
		
		for (LeafNode l : intervals) {
			totalCost += l.getCost();
		}
		eval.setTotalCost(totalCost);
		
		eval.setUsedLeaves(usedLeaves);
		
		return eval;
	}
}
