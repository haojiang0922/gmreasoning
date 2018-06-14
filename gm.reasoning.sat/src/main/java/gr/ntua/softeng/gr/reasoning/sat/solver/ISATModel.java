package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.Map;

public interface ISATModel {

	public Map<String, Boolean> getNodeValues();
	public Map<String, Boolean> getLeafValues();
	public String toString();
}
