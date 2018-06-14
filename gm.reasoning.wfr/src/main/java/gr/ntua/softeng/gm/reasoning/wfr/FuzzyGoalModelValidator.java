package gr.ntua.softeng.gm.reasoning.wfr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gr.ntua.softeng.gm.model.GoalModel;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.GoalModelRule;
import gr.ntua.softeng.gm.reasoning.GoalModelReasoningException;
import gr.ntua.softeng.gm.reasoning.GoalModelValidator;

public class FuzzyGoalModelValidator implements GoalModelValidator {

	@Override
	public boolean isValid(GoalModel<?, ?, ?> gm) throws GoalModelReasoningException {
		List<String> errors = new ArrayList<>();
		Set<String> nodesWithDecomposition = new HashSet<>();
		// Check that there is at most one decomposition for each node
		Collection<GoalModelRule> rules = gm.getRules();
		for (GoalModelRule r : rules) {
			if (r instanceof Decomposition) {
				String parentNode = ((Decomposition) r).getParent();
				if (!nodesWithDecomposition.add(parentNode)) {
					errors.add("Multiple decomposition rules for node \"" + parentNode + "\"");
				}
			}
		}
		if (!errors.isEmpty()) {
			throw new GoalModelReasoningException("Invalid Goal Model!", errors);
		}
		return true;
	}

}
