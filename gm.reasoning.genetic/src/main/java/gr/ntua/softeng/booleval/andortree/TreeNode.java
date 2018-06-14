package gr.ntua.softeng.booleval.andortree;

import java.util.ArrayList;

public abstract class TreeNode {

	protected ArrayList<TreeNode> children;
	private TreeNode parent = null;
	protected String label = "";
	private int begin;
	private int end;
	int leftLeaves = 0;
	int size = 1;

	public void setSize(int size) {
		this.size = size;
	}


	public String getLabel() {
		return label;
	}


	public ArrayList<TreeNode> getChildren() {
		return children;
	}


	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	protected TreeNode() {
		children = new ArrayList<TreeNode>();
	}

	public String getAnnotation() {
		return "<"+begin+","+end+">";
	}

	public int getBegin() {
		return begin;
	}


	public void setBegin(int begin) {
		this.begin = begin;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public int getSize() {
		return size;
	}


	public int getLeftLeaves() {
		return leftLeaves;
	}
	
	public void setLeftLeaves(int leftLeaves) {
		this.leftLeaves = leftLeaves;
	}
	
	public ArrayList<OperatorNode> getOperatorChildren() {
		ArrayList<OperatorNode> oc = new ArrayList<OperatorNode>();
		for (TreeNode n : this.getChildren()) {
			if (n instanceof OperatorNode)
				oc.add((OperatorNode)n);
		}
		return oc;
	}

}
