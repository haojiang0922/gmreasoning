package gr.ntua.softeng.gm.model.view.andor;

import java.util.Map;
import java.util.Set;

public interface Evaluator {

	public boolean evaluate(Map<String,Boolean> values, Set<String> trueNodes);
}
