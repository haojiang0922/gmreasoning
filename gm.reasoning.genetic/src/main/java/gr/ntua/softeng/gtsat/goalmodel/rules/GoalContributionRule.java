package gr.ntua.softeng.gtsat.goalmodel.rules;


public class GoalContributionRule {

	public static final int PPS = 1;
	public static final int MMS = 2;
	public static final int PPD = 3;
	public static final int MMD = 4;
	
	private String sourceNodeKey;
	private String targetNodeKey;
	private int type;
	
	public GoalContributionRule(String sourceNodeKey, String targetNodeKey, int type) {
		this.sourceNodeKey = sourceNodeKey;
		this.targetNodeKey = targetNodeKey;
		this.type = type;
	}
	
	public String getSourceNodeKey() {
		return sourceNodeKey;
	}
	
	public String getTargetNodeKey() {
		return targetNodeKey;
	}
	
	public boolean isPPS() {
		return this.type == PPS;
	}
	
	public boolean isMMS() {
		return this.type == MMS;
	}
	
	public boolean isPPD() {
		return this.type == PPD;
	}
	
	public boolean isMMD() {
		return this.type == MMD;
	}
	
	public void setTargetNodeKey(String targetNodeKey) {
		this.targetNodeKey = targetNodeKey;
	}
}
