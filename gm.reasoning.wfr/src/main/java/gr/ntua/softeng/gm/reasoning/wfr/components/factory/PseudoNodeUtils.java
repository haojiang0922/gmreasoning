package gr.ntua.softeng.gm.reasoning.wfr.components.factory;

public class PseudoNodeUtils {

	public static String getGoalPseudoNodeName(String goalName, Double weight) {
		StringBuilder buffer = new StringBuilder();
		buffer.append(goalName).append("W").append(weight);
		String name = buffer.toString().replace(".", "").replace(",", "");
		return name;
	}

}
