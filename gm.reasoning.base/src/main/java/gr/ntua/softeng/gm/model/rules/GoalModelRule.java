package gr.ntua.softeng.gm.model.rules;

import java.util.Collection;


public interface GoalModelRule {

	public String getConsequent();
	public Collection<String> getAntecedents();
}
