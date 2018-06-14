package gr.ntua.softeng.gm.model;

import java.util.Map;
import java.util.Set;

public interface IGoalModelAbstraction {
	
	public void addANDDecomposition(String parentNodeKey, Set<String> childNodeKeys);
	public void addORDecomposition(String parentNodeKey, Set<String> childNodeKeys);
	public void addPPSContribution(String sourceNodeKey, String targetNodeKey);
	public void addMMSContribution(String sourceNodeKey, String targetNodeKey);
	public void addPPDContribution(String sourceNodeKey, String targetNodeKey);
	public void addMMDContribution(String sourceNodeKey, String targetNodeKey);
	
	public void addWeightedNode(String nodeKey, Integer nodeWeight);
	public void updateWeightedNode(String nodeKey, Integer newNodeWeight, UpdateHandler handler);
	public void updateWeightedNodes(Map<String,Integer> newNodeWeights, UpdateHandler handler);
	
	public void addGoal(String nodeKey);
	public void addAntiGoal(String nodeKey);
	
	public void addPrecedenceLink(String sourceNodeKey, String targetNodeKey);
	public void addPreconditionLink(String sourceNodeKey, String targetNodeKey);
}
