package gr.ntua.softeng.booleval.andortree;

import gr.ntua.softeng.gtsat.cnf.Literal;

public class LeafNode extends TreeNode {

	private Literal literal;
	private String expression;
	private double cost = 0;
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	public LeafNode() {
		super();
	}
	public LeafNode(String annotation) {
		super();
		this.label = annotation;
	}
	public LeafNode(Literal l) {
		this.literal = l;
		this.label = System.nanoTime() + "_[" + l.getLiteralCode() + "]";
	}
	public Literal getLiteral() {
		return literal;
	}
	public void setLiteral(Literal literal) {
		this.literal = literal;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;		
	}

}
