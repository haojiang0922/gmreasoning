package gr.ntua.softeng.booleval.test;

import gr.ntua.softeng.booleval.Evaluation;
import gr.ntua.softeng.booleval.andortree.AndOrTree;
import gr.ntua.softeng.booleval.andortree.LeafNode;
import gr.ntua.softeng.booleval.andortree.Operator;
import gr.ntua.softeng.booleval.andortree.OperatorNode;
import gr.ntua.softeng.booleval.andortree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class RandomTreeGenerator {

	public static void main(String[] args) {
		Evaluation eval = null;
		AndOrTree tree = null;
		Random rand = new Random();
		do {
			tree = generateAndOrTree(rand.nextInt(4)+1, rand.nextInt(5000)+100, rand.nextInt(30000)+150);
			if (tree != null) {
				tree.initializeAllTreeNodes();
				tree.labelTree();			
				int from = rand.nextInt(tree.getLeaves().size());
				int to = rand.nextInt(tree.getLeaves().size() - from) + from + 1;
				ArrayList<LeafNode> sublist = new ArrayList<LeafNode>(tree.getLeaves().subList(from,to));
				eval = AndOrTree.match(sublist, tree.getLeaves().size());
				System.out.println(tree.getDepth() + "\t" + tree.getOperatorsCnt() + "\t" + tree.getLeavesCnt() + "\t" + (to-from) + "\t" + eval);
			}
		} while (eval.getTime() < 100000000 /*tree==null || eval.getResult()*/);
				
	}

	private static ArrayList<LeafNode> pickRandomIntervals(
			ArrayList<TreeNode> nodes, int i) {
		ArrayList<LeafNode> out = new ArrayList<LeafNode>();
		int cnt = 0;
		Random rand = new Random();
		while (cnt < i) {
			TreeNode n = nodes.get(rand.nextInt(nodes.size()));
				if (n instanceof LeafNode) {
					if (!out.contains(n)) {
						out.add((LeafNode)n);
						cnt++;
					}
				}
		}
		return out;
	}

	public static AndOrTree generateAndOrTree(int depth, int operators, int leafs) {
		if (depth > operators) 
			return null;
		if (operators / depth > leafs)
			return null;
		
		AndOrTree tree = new AndOrTree();
		
		OperatorNode root = new OperatorNode(Operator.OR);
		root.setDepth(1);
		tree.setRoot(root);
		
		Random rand = new Random();
		
		int leafsAdded = 0;
		int operatorsAdded = 0;

		int maxDepth = 1;
		TreeNode parent = null;
		for (int d = 2; d <= depth-1; d++) {
			int opsInDepth = rand.nextInt(operators / depth) + 2;
			for (int o = 1; o <= opsInDepth && operators-operatorsAdded > 0; o++) {
				parent = selectParent(tree, d-1);
				if (d % 2 == 0) {
					OperatorNode and = new OperatorNode(Operator.AND);
					and.setDepth(d);
					parent.getChildren().add(and);
				}
				else {
					OperatorNode or = new OperatorNode(Operator.OR);
					or.setDepth(d);
					parent.getChildren().add(or);
				}
				operatorsAdded++;
				maxDepth = d;
			}
		}
		
		while (leafs - leafsAdded > 0) {
			int tempDepth = rand.nextInt(maxDepth)+2;
			if (tempDepth == maxDepth+1) tempDepth = maxDepth;
			parent = selectParent(tree,tempDepth);
				LeafNode l = new LeafNode(System.nanoTime()+"");
				l.setCost(-rand.nextDouble());
				parent.getChildren().add(l);
				leafsAdded++;
		}
		
		for (int i = 2; i <= depth - 1; i++) {
			ArrayList<OperatorNode> nodes = getOperatorNodesOfDepth(tree.getRoot(), i);
			for (OperatorNode o : nodes) {
				if (o.getChildren().size() - o.getOperatorChildren().size() == 0) {
					LeafNode l = new LeafNode(System.nanoTime()+"");
					l.setCost(-rand.nextDouble());
					o.getChildren().add(l);
					leafsAdded++;
				}
			}
		}
		
		tree.setDepth(maxDepth+1);
		tree.setOperatorsCnt(operatorsAdded+1);
		tree.setLeavesCnt(leafsAdded);
		
		return tree;
		
	}

	private static TreeNode selectParent(AndOrTree tree, int depth) {
		TreeNode parent = tree.getRoot();
		if (depth == 1) return parent;
		ArrayList<OperatorNode> nodes = getOperatorNodesOfDepth((OperatorNode)tree.getRoot(),depth);
		Collections.sort(nodes, new Comparator<OperatorNode>() {

			@Override
			public int compare(OperatorNode node1, OperatorNode node2) {
				if (node1.getChildren().size() - node1.getOperatorChildren().size() > node2.getChildren().size() - node2.getOperatorChildren().size())
					return 1;
				else if (node1.getChildren().size() - node1.getOperatorChildren().size() < node2.getChildren().size() - node2.getOperatorChildren().size())
					return -1;
				else 
					return 0;
			}
			
		});
		parent = nodes.get(0);
		return parent;
	}

	private static ArrayList<OperatorNode> getOperatorNodesOfDepth(OperatorNode parent, int depth) {
		ArrayList<OperatorNode> out = new ArrayList<OperatorNode>();
		for (OperatorNode o : parent.getOperatorChildren()) {
			if (o.getDepth() == depth)
				out.add(o);
			else out.addAll(getOperatorNodesOfDepth(o,depth));
		}
		return out;
	}
}
