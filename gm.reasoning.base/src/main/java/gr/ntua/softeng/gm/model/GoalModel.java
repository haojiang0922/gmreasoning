package gr.ntua.softeng.gm.model;

import java.util.List;
import java.util.Set;

import gr.ntua.softeng.gm.model.rules.ContributionType;
import gr.ntua.softeng.gm.model.rules.DecompositionType;
import gr.ntua.softeng.gm.model.rules.GoalModelRule;

public interface GoalModel<G, D, C> {
	
	public void addDecomposition(Goal parent, List<Goal> childNodes, DecompositionType type, D data);
	public void addDecomposition(Goal parent, List<Goal> childNodes, DecompositionType type);
	
	public void addContribution(Goal source, Goal target, ContributionType type, C data);
	public void addContribution(Goal source, Goal target, ContributionType type);
	
	public List<Goal> getRootNodes();
	public List<Goal> getLeafNodes();
	public List<Goal> getAllNodes();
	
	/*
	 * Create a new node or return the node with the given id if
	 * one exists 
	 */
	public Goal goal(String id, G data);
	public Goal goal(String id);
	
	public Set<GoalModelRule> getRules();
	
}
