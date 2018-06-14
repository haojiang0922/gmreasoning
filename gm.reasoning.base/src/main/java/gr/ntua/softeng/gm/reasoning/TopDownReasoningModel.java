package gr.ntua.softeng.gm.reasoning;

import java.util.Map;

public interface TopDownReasoningModel<T extends Value> extends ReasoningModel {
		
	public Map<String, T> applyTopDownReasoning(Map<String, T> constraints);
	
}
