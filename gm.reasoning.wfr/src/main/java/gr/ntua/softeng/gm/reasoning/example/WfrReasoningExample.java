package gr.ntua.softeng.gm.reasoning.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.fuzzy.FuzzyGoalModel;
import gr.ntua.softeng.gm.model.rules.DecompositionType;
import gr.ntua.softeng.gm.reasoning.wfr.LowHighNodeValue;
import gr.ntua.softeng.gm.reasoning.wfr.LowHighValueHelper;
import gr.ntua.softeng.gm.reasoning.wfr.WFRReasoningModel;
import gr.ntua.softeng.gm.reasoning.wfr.WFRReasoningModelGenerator;
import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.HighMemFunc;
import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.LowMemFunc;

public class WfrReasoningExample {

	private static final double GOAL_B_SATISFACTION_DEGREE = 100.0;
	private static final double GOAL_C_SATISFACTION_DEGREE = 0.0;
	
	public static void main(String[] args) {
		// Create the goal model
		FuzzyGoalModel<?, ?> gm = new FuzzyGoalModel<>();
		List<Goal> childNodes = new ArrayList<>();
		Goal a  = gm.goal("a"), b = gm.goal("b"), c = gm.goal("c");
		childNodes.add(b);
		childNodes.add(c);
		gm.addDecomposition(a, childNodes, DecompositionType.AND);
		// Membership functions
		LowMemFunc lowMemFunc = new LowMemFunc(10, 60);
		HighMemFunc highMemFunc = new HighMemFunc(90, 40);
		LowHighValueHelper valueHelper = new LowHighValueHelper(lowMemFunc, highMemFunc);
		// Initial Values - Fuzzification
		Map<String, LowHighNodeValue> initialValues = new HashMap<>();
		initialValues.put("b", valueHelper.getValue(GOAL_B_SATISFACTION_DEGREE));
		initialValues.put("c",  valueHelper.getValue(GOAL_C_SATISFACTION_DEGREE));
		// Print Initial Values
		for (String nodeName : initialValues.keySet()) {
			System.out.println("Initial value for node:\"" + nodeName + "\" is " + initialValues.get(nodeName));
		}
		// Apply reasoning
		WFRReasoningModelGenerator gen = new WFRReasoningModelGenerator();
		WFRReasoningModel reasoningModel = gen.generateReasoningModel(gm);
		Map<String, LowHighNodeValue> results = reasoningModel.applyBottomUpReasoning(initialValues);
		// Print Results - defuzzification
		for (String node : results.keySet()) {
			LowHighNodeValue nodeValue = results.get(node);
			System.out.println("Node: " + node + ", Value:" + nodeValue + ", DefuzValue:" + valueHelper.getSatisfactionDegree(nodeValue));
		}
	}	
	
}
