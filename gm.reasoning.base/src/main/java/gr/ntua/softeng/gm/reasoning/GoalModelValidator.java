package gr.ntua.softeng.gm.reasoning;

import gr.ntua.softeng.gm.model.GoalModel;

public interface GoalModelValidator {

	public boolean isValid(GoalModel<?, ?, ?> gm) throws GoalModelReasoningException;
	
}
