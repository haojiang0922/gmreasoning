package gr.ntua.softeng.gm.reasoning;

import gr.ntua.softeng.gm.model.GoalModel;

public abstract class ReasoningModelGenerator<T extends GoalModelValidator, P extends ReasoningModel> {

	protected T validator;
	
	protected ReasoningModelGenerator(T validator) {
		this.validator = validator;
	}
	
	public P generateReasoningModel(GoalModel<?, ?, ?> gm) throws GoalModelReasoningException {
		P reasoningModel = null;
		boolean modelIsValid = this.validator.isValid(gm);
		if (modelIsValid) {
			reasoningModel = this.generateReasoningModelFromGoalModel(gm);
		}
		return reasoningModel;
	}
	
	protected abstract P generateReasoningModelFromGoalModel(GoalModel<?, ?, ?> gm);
	
}
