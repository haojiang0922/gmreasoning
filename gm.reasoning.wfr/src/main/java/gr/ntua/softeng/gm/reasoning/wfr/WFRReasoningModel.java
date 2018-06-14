package gr.ntua.softeng.gm.reasoning.wfr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.ntua.softeng.gm.reasoning.BottomUpReasoningModel;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyFact;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyLogicProgram;
import gr.ntua.softeng.gm.reasoning.wfr.components.factory.FuzzyRulesFactory;

public class WFRReasoningModel implements BottomUpReasoningModel<LowHighNodeValue> {

	private FuzzyRulesFactory rulesFactory;
	private FuzzyLogicProgram program;
	private List<String> gmNodes;
	
	public WFRReasoningModel(List<String> gmNodes, FuzzyLogicProgram program, FuzzyRulesFactory rulesFactory) {
		if (program==null) throw new IllegalArgumentException();
		this.program = program;
		this.rulesFactory = rulesFactory;
		this.gmNodes = gmNodes;
	}
	
	@Override
	public Map<String, LowHighNodeValue> applyBottomUpReasoning(Map<String, LowHighNodeValue> initialValues) {
		this.program.reset();
		// Create fuzzy facts for the initial values provided
		for (String nodeName : initialValues.keySet()) {
			LowHighNodeValue value = initialValues.get(nodeName);
			if (value!=null) {
				List<FuzzyFact> facts = this.rulesFactory.createNodeFuzzyFacts(nodeName, value.getHigh(), value.getLow());
				this.program.addFacts(facts);
			}			
		}
		// Run the reasoning process
		FuzzyProgramReasoner reasoner = new FuzzyProgramReasoner(this.program);
		reasoner.performReasoning();
		// Get the results
		 Map<String, LowHighNodeValue> reasoningResults = new HashMap<>();
		for (String nodeName : this.gmNodes) {
			LowHighNodeValue nodeValue = new LowHighNodeValue();
			// High
			String highSatQuery = this.rulesFactory.getHighSatQueryForNode(nodeName);
			String highRes = reasoner.executeQuery(highSatQuery);
			try {
				Double highValue = Double.parseDouble(highRes);
				nodeValue.setHigh(highValue);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			// Low
			String lowSatQuery = this.rulesFactory.getLowSatQueryForNode(nodeName);
			String lowRes = reasoner.executeQuery(lowSatQuery);
			try {
				Double lowValue = Double.parseDouble(lowRes);
				nodeValue.setLow(lowValue);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			reasoningResults.put(nodeName, nodeValue);
		}
		return reasoningResults;
	}

}
