package gr.ntua.softeng.wtt.sat.opt.cnf;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.IEvaluationStrategy;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;
import gr.ntua.softeng.wtt.sat.WTT2GoalModelTransformer;


public class WTT2CNFTransformer {
	
	private CNFGeneticMaxSatWrapper cnfWrapper = null;
	
	public WTT2CNFTransformer(String filename, IEvaluationStrategy strategy) {
		WTT2GoalModelTransformer t = new WTT2GoalModelTransformer(filename);
		// Create the corresponding goal model abstraction
		GoalModelAbstraction goalModel = t.getGoalModelAbstraction();
		this.cnfWrapper = new CNFGeneticMaxSatWrapper(goalModel, strategy);
	}
	
	public CNFGeneticMaxSatWrapper getCNFWrapper() {
		return this.cnfWrapper;
	}
}
