package gr.ntua.softeng.gtsat.cnf.eval;

import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

public interface IEvaluationStrategy {

	public AbstractCNFFormulaEvaluator createEvaluator(CNFGeneticMaxSatWrapper wrapper);
}
