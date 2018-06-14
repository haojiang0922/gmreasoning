package gr.ntua.softeng.gtsat;

import gr.ntua.softeng.gtsat.cnf.AbstractClause;
import gr.ntua.softeng.gtsat.cnf.CNFSatWrapper;
import gr.ntua.softeng.gtsat.cnf.CNFMaxSatWrapper;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;

import org.sat4j.core.VecInt;
import org.sat4j.maxsat.WeightedMaxSatDecorator;
import org.sat4j.pb.IPBSolver;
import org.sat4j.pb.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

public class GoalModelMaxSATSolver extends GoalModelSATSolver {

	public GoalModelMaxSATSolver(GoalModelAbstraction modelDecorator) throws ContradictionException {
		super(modelDecorator);
	}
	
	protected CNFSatWrapper getFormulaInstance(GoalModelAbstraction modelDecorator) {
		return new CNFMaxSatWrapper(modelDecorator);
	}
	
	protected ISolver setupSolver() throws ContradictionException {
		IPBSolver solver = SolverFactory.newDefault ();
		WeightedMaxSatDecorator weightedMaxSatSolver = new WeightedMaxSatDecorator(solver);
		weightedMaxSatSolver.newVar(this.formula.getNumOfAtoms());
		weightedMaxSatSolver.setExpectedNumberOfClauses (this.formula.getNumOfClauses());
		weightedMaxSatSolver.setTimeout (3600); // 1 hour timeout
		
		for (AbstractClause c : this.formula.getClauses()) {
			int[] clause = c.getDIMACSFormat();
			if(c.isHard()) {
				weightedMaxSatSolver.addHardClause(new VecInt(clause));
			} else {
				weightedMaxSatSolver.addSoftClause(c.getWeight(), new VecInt(clause));
			}
		}
		
		return solver;
	}
	
	public MaxSATModel getModel() throws TimeoutException {
		return (MaxSATModel) super.getModel();
	}
}
