package gr.ntua.softeng.gtsat.cnf.eval;

import gr.ntua.softeng.gtsat.cnf.CNFFormula;
import gr.ntua.softeng.gtsat.cnf.CNFGeneticMaxSatWrapper;

import java.util.ArrayList;

public abstract class AbstractCNFFormulaEvaluator {
	
	private CNFGeneticMaxSatWrapper wrapper = null;
	
	public AbstractCNFFormulaEvaluator(CNFGeneticMaxSatWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	public CNFFormula getFormula() {
		return wrapper.getCNFFormula();
	}
	
	protected CNFGeneticMaxSatWrapper getWrapper() {
		return wrapper;
	}

	public abstract boolean checkAssignment(ArrayList<Boolean> assignment);
	
	public abstract double getEvaluationTime();

}
