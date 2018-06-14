package gr.ntua.softeng.gr.reasoning.sat.solver;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;

public class SATSolver {

	private ModelIterator modelIterator;
	protected SatCNFFormula formula;
	
	public SATSolver(SatCNFFormula formula) throws ContradictionException {
		this.setFormula(formula);
		ISolver solver = setupSolver();
		modelIterator = new ModelIterator(solver);
	}
	
	protected ISolver setupSolver() throws ContradictionException {
		ISolver solver = SolverFactory.newDefault ();
		solver.newVar(this.formula.getNumOfAtoms());
		solver.setExpectedNumberOfClauses (this.formula.getNumOfClauses());
		solver.setTimeout (3600); // 1 hour timeout
		for (int[] c : formula.getClausesInDIMACS()) {
			solver.addClause(new VecInt(c));
		}
		return solver;
	}
	
	public boolean isSatisfiable() throws TimeoutException {
		return modelIterator.isSatisfiable();
	}
	
	public ISATModel getModel() throws TimeoutException {
		ISATModel currentModel = null;
		if (modelIterator.isSatisfiable()) {
			int[] model = modelIterator.model();
			currentModel = formula.translateModel(model);
		}
		return currentModel;
	}

	public SatCNFFormula getFormula() {
		return formula;
	}

	public void setFormula(SatCNFFormula formula) {
		this.formula = formula;
	}
}
