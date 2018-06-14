package gr.ntua.softeng.wtt.test;

import gr.ntua.softeng.wtt.sat.solver.WTTMaxSatSolver;

public class SolverTest {

	private static final String WTT_FILE = "test_costs.wtt";//"models/random/WTT_1383662188915.wtt";//"test_costs.wtt";
	
	public static void main(String[] args) {
		String file = WTT_FILE;
		if (args != null && args.length == 1) 
			file = args[0];
		// Opt4J MaxSat Solver
		WTTMaxSatSolver opt4jSolver = new WTTMaxSatSolver(file);
		opt4jSolver.execute();
		// Evolutionary Solver for CNF
//		CNFEvolutionarySolver cnfEvalSolver = new CNFEvolutionarySolver(file, 1000);
//		cnfEvalSolver.execute();
		// Gasat Solver for CNF
//		CNFGasatSolver cnfGasatSolver = new CNFGasatSolver(file, 1000);
//		cnfGasatSolver.execute();
//		
//		
//		System.out.println("\n\nTimer:");
//		System.out.println("Total : " + GasatTimer.getTotalTime());
//		System.out.println("Selection : " + GasatTimer.getSelectionTime());
//		System.out.println("Lames : " + GasatTimer.getRemoveLamesTime());
//		System.out.println("Mating : " + GasatTimer.getMatingTime());
//		System.out.println("Offsrpings : " + GasatTimer.getOffspringsTime());
//		System.out.println("Offsrpings Selection: " + GasatTimer.getOffspringsSelectionTime());
//		
//		GasatTimer.init();
//		
//		CNFGasatImprovedSolver cnfImprovedGasatSolver = new CNFGasatImprovedSolver(file, 1000);
//		cnfImprovedGasatSolver.execute();
//		
//		
//		System.out.println("\n\nTimer:");
//		System.out.println("Total : " + GasatTimer.getTotalTime());
//		System.out.println("Selection : " + GasatTimer.getSelectionTime());
//		System.out.println("Lames : " + GasatTimer.getRemoveLamesTime());
//		System.out.println("Mating : " + GasatTimer.getMatingTime());
//		System.out.println("Offsrpings : " + GasatTimer.getOffspringsTime());
//		System.out.println("Offsrpings Selection: " + GasatTimer.getOffspringsSelectionTime());
	}		
}
