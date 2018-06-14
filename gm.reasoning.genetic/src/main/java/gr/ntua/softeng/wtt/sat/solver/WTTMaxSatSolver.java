package gr.ntua.softeng.wtt.sat.solver;

import gr.ntua.softeng.gtsat.GoalModelMaxSATSolver;
import gr.ntua.softeng.gtsat.MaxSATModel;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;
import gr.ntua.softeng.wtt.sat.WTT2GoalModelTransformer;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

public class WTTMaxSatSolver extends IWTTMaxSatSolver {

	private MaxSATModel model = null;
	private double time = 0;
	
	public WTTMaxSatSolver(String wttFile) {
		WTT2GoalModelTransformer t = new WTT2GoalModelTransformer(wttFile);
		GoalModelAbstraction goalModel = t.getGoalModelAbstraction();
		model = getMaxSatModel(goalModel);
	}
	
	private MaxSATModel getMaxSatModel(GoalModelAbstraction gm) {
		MaxSATModel maxSatModel = null;
		
		long start = System.nanoTime();
		try {
			GoalModelMaxSATSolver solver = new GoalModelMaxSATSolver(gm);
			if(solver.isSatisfiable()) {
				maxSatModel = solver.getModel();
			} else {
				System.out.println("Unsatisfiable!");
			}
		} catch(ContradictionException e) {
			System.out.println("Unsatisfiable (contradiction found)!");
		} catch (TimeoutException e) {
			System.out.println("Execution time exceeded limit!");
		}
		this.time = (double)(System.nanoTime() - start)/1000000.0;
		return maxSatModel;
	}

	@Override
	public MaxSATModel getModel() {
		return model;
	}

	@Override
	public double getTimeInMillis() {
		return time;
	}
}
