package gr.ntua.softeng.gtsat.goalmodel;

import java.util.Set;

public interface IGoalModelAbstraction {
	
	public static final String PSEUDO_NODE_IDENTIFIED = "#PSEUDO#";
	
	public void addANDDecomposition(String parentNodeKey, Set<String> childNodeKeys);
	public void addORDecomposition(String parentNodeKey, Set<String> childNodeKeys);
	public void addPPSContribution(String sourceNodeKey, String targetNodeKey);
	public void addMMSContribution(String sourceNodeKey, String targetNodeKey);
	public void addPPDContribution(String sourceNodeKey, String targetNodeKey);
	public void addMMDContribution(String sourceNodeKey, String targetNodeKey);
	
	public void addWeightedNode(String nodeKey, int nodeWeight);
	
	public void addGoal(String nodeKey);
	public void addAntiGoal(String nodeKey);
}
