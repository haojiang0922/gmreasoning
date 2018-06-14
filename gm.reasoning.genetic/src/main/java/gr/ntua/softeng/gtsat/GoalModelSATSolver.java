package gr.ntua.softeng.gtsat;

import gr.ntua.softeng.gtsat.cnf.CNFSatWrapper;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;

public class GoalModelSATSolver {

	private ModelIterator modelIterator;
	protected CNFSatWrapper formula;
	
	public GoalModelSATSolver(GoalModelAbstraction modelDecorator) throws ContradictionException {
		this.formula = getFormulaInstance(modelDecorator);
		ISolver solver = setupSolver();
		modelIterator = new ModelIterator(solver);
	}
	
	protected CNFSatWrapper getFormulaInstance(GoalModelAbstraction modelDecorator) {
		return new CNFSatWrapper(modelDecorator);
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
	
	public SATModel getModel() throws TimeoutException {
		SATModel currentModel = null;
		if (modelIterator.isSatisfiable()) {
			int[] model = modelIterator.model();
			currentModel = formula.translateModel(model);
		}
		return currentModel;
	}
}
