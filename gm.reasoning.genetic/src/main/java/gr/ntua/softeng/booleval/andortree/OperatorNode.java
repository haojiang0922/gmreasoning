package gr.ntua.softeng.booleval.andortree;

public class OperatorNode extends TreeNode {
	
	private int depth;

	public Operator getOperator() {
		return operator;
	}


	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	private Operator operator;

	
	public OperatorNode(Operator opIn) {
		super();
		operator = opIn;
		this.label = operator.toString();
	}
	
	public boolean addChild(TreeNode child) {
		if (child instanceof LeafNode) {
			children.add(child);
			child.setParent(this);
			return true;
		}
		else if (child instanceof OperatorNode) {
			if (((OperatorNode) child).getOperator().equals(this.getOperator()))
				return false;
			else {
				children.add(child);
				child.setParent(this);
				return true;
			}
		}
		return false;
	}


	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getAnnotation() {
		return super.getAnnotation() + (this.getDepth() == 1 ? " [ROOT]" : "");		
	}
}
