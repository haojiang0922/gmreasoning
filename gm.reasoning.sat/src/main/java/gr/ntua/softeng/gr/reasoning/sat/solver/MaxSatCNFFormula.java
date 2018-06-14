package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.List;
import java.util.Map;

public interface MaxSatCNFFormula extends SatCNFFormula {

	public List<int[]> getHardClausesInDIMACS();
	public Map<int[], Integer> getSoftClausesInDIMACS();
	public IMaxSATModel translateModel(int[] model);
}
