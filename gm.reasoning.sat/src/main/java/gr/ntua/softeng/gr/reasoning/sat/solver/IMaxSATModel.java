package gr.ntua.softeng.gr.reasoning.sat.solver;

public interface IMaxSATModel extends ISATModel {

	public Integer getTotalCost(boolean recalculate);
}
