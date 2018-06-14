package gr.ntua.softeng.booleval;

import gr.ntua.softeng.booleval.andortree.LeafNode;
import gr.ntua.softeng.gtsat.cnf.Atom;
import gr.ntua.softeng.gtsat.cnf.Literal;

public class IntervalLiteral extends Literal {

	private LeafNode leafNode = null;
	
	public IntervalLiteral(Atom atom, boolean isNegated) {
		super(atom, isNegated);
	}

	public LeafNode getLeafNode() {
		return leafNode;
	}

	public void setLeafNode(LeafNode leafNode) {
		this.leafNode = leafNode;
	}	
}
