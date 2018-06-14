package gr.ntua.softeng.wtt.test;

import gr.ntua.softeng.wtt.sat.opt.cnf.CostObjectives;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CostObjectives obj1 = new CostObjectives(-8, 2);
		CostObjectives obj2 = new CostObjectives(-8, 4);
		System.out.println(obj1.dominates(obj2));
		
		System.out.println(obj2.dominates(obj1));
	}

}
