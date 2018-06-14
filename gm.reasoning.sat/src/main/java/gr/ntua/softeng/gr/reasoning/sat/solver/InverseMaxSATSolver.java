package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.Map.Entry;

import org.sat4j.core.VecInt;
import org.sat4j.maxsat.SolverFactory;
import org.sat4j.maxsat.WeightedMaxSatDecorator;
import org.sat4j.pb.IPBSolver;
import org.sat4j.pb.OptToPBSATAdapter;
import org.sat4j.pb.PseudoOptDecorator;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

public class InverseMaxSATSolver extends SATSolver {

	private OptToPBSATAdapter solver;
	
	public InverseMaxSATSolver(MaxSatCNFFormula formula) throws ContradictionException {
		super(formula);
	}
	
	protected ISolver setupSolver() throws ContradictionException {
		IPBSolver defaultSolver = SolverFactory.newDefault();
		WeightedMaxSatDecorator weightedMaxSatSolver = new WeightedMaxSatDecorator(defaultSolver);
		weightedMaxSatSolver.newVar(this.formula.getNumOfAtoms());
		weightedMaxSatSolver.setExpectedNumberOfClauses (this.formula.getNumOfClauses());
		weightedMaxSatSolver.setTimeout (3600); // 1 hour timeout
		
		MaxSatCNFFormula f = (MaxSatCNFFormula) this.formula;
		// Add Hard Clauses
		for( int[] clause : f.getHardClausesInDIMACS() ) {
			weightedMaxSatSolver.addHardClause(new VecInt(clause));
		}
		//ArrayList<Integer> softLiterals = new ArrayList<>();
		//ArrayList<Integer> softLiteralsWeights = new ArrayList<>();
		// Add Soft Clauses
		for( Entry<int[], Integer> softClause : f.getSoftClausesInDIMACS().entrySet() ) {
			//softLiterals.add(softClause.getKey()[0]);
			//softLiteralsWeights.add(-softClause.getValue());
			weightedMaxSatSolver.addSoftClause(-softClause.getValue(), new VecInt(softClause.getKey()));
		}
		//weightedMaxSatSolver.addWeightedLiteralsToMinimize(new VecInt(toArray(softLiterals)), new VecInt(toArray(softLiteralsWeights)));
		PseudoOptDecorator pseudoOptSolver = new PseudoOptDecorator(weightedMaxSatSolver);
		this.solver = new OptToPBSATAdapter(pseudoOptSolver);
		return this.solver;
	}
	
//	private int[] toArray(List<Integer> list) {
//		int[] array = new int[list.size()];
//		int pos = 0;
//		for (Integer i : list) {
//			array[pos++] = i;
//		}
//		return array;
//	}
	
	public IMaxSATModel getModel() throws TimeoutException {
		if (this.solver.isOptimal()) {
			int[] model = this.solver.model();
			return ((MaxSatCNFFormula)this.formula).translateModel(model);
		} else {
			return null;
		}
		
	}
}
