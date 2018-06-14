package gr.ntua.softeng.wtt.sat.solver;

import gr.ntua.softeng.gtsat.MaxSATModel;

public abstract class IWTTMaxSatSolver {

	public abstract MaxSATModel getModel();
	public abstract double getTimeInMillis();
	
	public void execute() {
		MaxSATModel model = this.getModel();
		if (model != null) {
			System.out.println("PW-MAXSAT\ttime (msec): " + this.getTimeInMillis());
			System.out.println(model);
		} else {
			System.out.println("PW-MAXSAT\ttime (msec): " + this.getTimeInMillis());
			System.out.println("No model found!");
		}
	}
}
