package gr.ntua.softeng.gm.reasoning;

import java.util.List;

@SuppressWarnings("serial")
public class GoalModelReasoningException extends RuntimeException {

	private List<?> errors;
	
	public GoalModelReasoningException(String message) {
		super(message);
	}

	public GoalModelReasoningException(String message, List<?> errors) {
		super(message);
		this.errors = errors;
	}
	
	@Override
	public String getMessage() {
		StringBuilder bf = new StringBuilder();
		bf.append(super.getMessage()).append("\nErrors:\n");
		bf.append(errors);
		return bf.toString();
	}
}
