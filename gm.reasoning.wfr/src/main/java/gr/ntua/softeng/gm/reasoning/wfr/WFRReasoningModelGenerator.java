package gr.ntua.softeng.gm.reasoning.wfr;

import java.util.ArrayList;
import java.util.List;

import gr.ntua.softeng.gm.model.Goal;
import gr.ntua.softeng.gm.model.GoalModel;
import gr.ntua.softeng.gm.model.impl.ext.WeightedContribution;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.DecompositionType;
import gr.ntua.softeng.gm.model.rules.GoalModelRule;
import gr.ntua.softeng.gm.reasoning.ReasoningModelGenerator;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyLogicProgram;
import gr.ntua.softeng.gm.reasoning.wfr.components.WeightedFuzzyRule;
import gr.ntua.softeng.gm.reasoning.wfr.components.factory.FuzzyRulesFactory;

public class WFRReasoningModelGenerator extends ReasoningModelGenerator<FuzzyGoalModelValidator, WFRReasoningModel> {

	private FuzzyRulesFactory rulesFactory = new FuzzyRulesFactory();
	
	public WFRReasoningModelGenerator() {
		super(new FuzzyGoalModelValidator());
	}
	
	@Override
	protected WFRReasoningModel generateReasoningModelFromGoalModel(GoalModel<?, ?, ?> gm) {
		FuzzyLogicProgram program = new FuzzyLogicProgram();
		for (GoalModelRule gmRule : gm.getRules()) {
			if (gmRule instanceof Contribution) {
				List<WeightedFuzzyRule> r = this.createWeightedFuzzyRule((WeightedContribution)gmRule);
				program.addRules(r);
			} else {
				List<WeightedFuzzyRule> r = this.createWeightedFuzzyRule((Decomposition)gmRule);
				program.addRules(r);
			}
		}
		List<String> gmNodes = this.extractNodeNames((List<Goal>)gm.getAllNodes());
		return new WFRReasoningModel(gmNodes, program, this.rulesFactory);
	}
	
	private List<String> extractNodeNames(List<Goal> nodes) {
		List<String> nodeNames = new ArrayList<>();
		for (Goal goalModelNode : nodes) {
			nodeNames.add(goalModelNode.getId());
		}
		return nodeNames;
	}
	
	private List<WeightedFuzzyRule> createWeightedFuzzyRule(WeightedContribution gmRule) {
		String target = gmRule.getTarget();
		String source = gmRule.getSource();
		Double weight = gmRule.getWeight();
		List<WeightedFuzzyRule> r = new ArrayList<>();
		switch (gmRule.getType()) {
			case PPS:
				r = rulesFactory.createPPSRules(target, source, weight, new ArrayList<String>());
				break;
			case MMS:
				r = rulesFactory.createMMSRules(target, source, weight, new ArrayList<String>());
				break;
			case PPD:
				r = rulesFactory.createPPDRules(target, source, weight, new ArrayList<String>());
				break;
			case MMD:
				r = rulesFactory.createMMDRules(target, source, weight, new ArrayList<String>());
				break;		
		}
		return r;
	}
	
	private List<WeightedFuzzyRule> createWeightedFuzzyRule(Decomposition gmRule) {
		List<WeightedFuzzyRule> decompositionRules;
		if (DecompositionType.AND.equals(gmRule.getType())) {
			decompositionRules = rulesFactory.createAndDecompositionRules(gmRule.getParent(), gmRule.getChildNodes());
		} else {
			decompositionRules = rulesFactory.createOrDecompositionRules(gmRule.getParent(), gmRule.getChildNodes());
		}
		return decompositionRules;
	}

}
