package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.List;

public interface SatCNFFormula {

	public int getNumOfClauses();
	public int getNumOfAtoms();
	public List<int[]> getClausesInDIMACS();
	public ISATModel translateModel(int[] model);
}
