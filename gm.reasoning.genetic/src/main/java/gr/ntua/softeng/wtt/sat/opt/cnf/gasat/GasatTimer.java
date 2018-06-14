package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

public class GasatTimer {
	
	private static long selectionTime = 0;
	private static long matingTime = 0;
	private static long offspringsTime = 0;
	private static long offspringsSelectionTime = 0;
	private static long removeLamesTime = 0;
	private static long totalTime = 0;
	
	public static void addSelectionTime(long t) {
		selectionTime += t;
	}
	
	public static void addMatingTime(long t) {
		matingTime += t;
	}
	
	public static void addOffsringTime(long t) {
		offspringsTime += t;
	}
	
	public static void addOffsringSelectionTime(long t) {
		offspringsSelectionTime += t;
	}
	
	public static void addRemoveLamesTime(long t) {
		removeLamesTime += t;
	}
	
	public static void addTotalTime(long t) {
		totalTime += t;
	}

	public static double getSelectionTime() {
		return selectionTime / 1000000.0;
	}

	public static double getMatingTime() {
		return matingTime  / 1000000.0;
	}

	public static double getOffspringsTime() {
		return offspringsTime  / 1000000.0;
	}
	
	public static double getOffspringsSelectionTime() {
		return offspringsSelectionTime  / 1000000.0;
	}

	public static double getRemoveLamesTime() {
		return removeLamesTime  / 1000000.0;
	}

	public static double getTotalTime() {
		return totalTime  / 1000000.0;
	}
	
	public static void init() {
		selectionTime = 0;
		matingTime = 0;
		offspringsTime = 0;
		offspringsSelectionTime = 0;
		removeLamesTime = 0;
		totalTime = 0;
	}
}
