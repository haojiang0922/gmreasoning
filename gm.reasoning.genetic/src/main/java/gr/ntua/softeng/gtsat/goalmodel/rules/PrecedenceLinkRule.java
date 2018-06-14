package gr.ntua.softeng.gtsat.goalmodel.rules;

public class PrecedenceLinkRule {

	private String sourceNodeKey;
	private String targetNodeKey;
	
	public PrecedenceLinkRule(String sourceNodeKey, String targetNodeKey) {
		this.sourceNodeKey = sourceNodeKey;
		this.targetNodeKey = targetNodeKey;
	}
	
	public String getSourceNodeKey() {
		return sourceNodeKey;
	}
	
	public String getTargetNodeKey() {
		return targetNodeKey;
	}
}
