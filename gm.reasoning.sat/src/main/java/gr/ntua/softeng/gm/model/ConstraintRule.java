package gr.ntua.softeng.gm.model;


public class ConstraintRule {

	private String nodeKey;
	private boolean value;
	
	public ConstraintRule(String nodeKey, boolean value) {
		this.nodeKey = nodeKey;
		this.value = value;
	}

	public String getName() {
		return nodeKey;
	}
	
	public boolean getValue() {
		return value;
	}
}
