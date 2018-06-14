package gr.ntua.softeng.wtt.sat;

import gr.ntua.softeng.booleval.AndOrTreeEvaluator;
import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;
import gr.ntua.softeng.gtsat.cnf.eval.AbstractCNFFormulaEvaluator;
import gr.ntua.softeng.gtsat.cnf.eval.IEvaluationStrategy;

public class AndOrTreeEvaluatorStrategy implements IEvaluationStrategy {

	@Override
	public AbstractCNFFormulaEvaluator createEvaluator(CNFGeneticMaxSatWrapper wrapper) {
		return new AndOrTreeEvaluator(wrapper);
	}
}
