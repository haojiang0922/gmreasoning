package gr.ntua.softeng.gtsat.goalmodel.rules;

public class ConstraintRule {

	private String nodeName;
	private boolean value;
	
	public ConstraintRule(String name, boolean value) {
		this.nodeName = name;
		this.value = value;
	}

	public String getName() {
		return nodeName;
	}
	
	public boolean getValue() {
		return value;
	}
}
