package gr.ntua.softeng.gm.model.rules;

import java.util.Collection;

public interface Decomposition extends GoalModelRule {

	public String getParent();
	public Collection<String> getChildNodes();
	public DecompositionType getType();
	public boolean isANDDecomposed();
	
}
