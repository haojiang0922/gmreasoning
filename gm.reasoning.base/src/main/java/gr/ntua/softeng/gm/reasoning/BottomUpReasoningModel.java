package gr.ntua.softeng.gm.reasoning;

import java.util.Map;

public interface BottomUpReasoningModel<T extends Value> extends ReasoningModel {
		
	/**
	 * Given an assignment for the leaf nodes, the values are propagated
	 * from the leafs up to the root node(s).
	 * 
	 * @param leafValues The assignment for the leaf nodes
	 * @return The values for all goal nodes in the model
	 */
	public Map<String, T> applyBottomUpReasoning(Map<String, T> leafValues);
	
}
