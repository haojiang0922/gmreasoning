package gr.ntua.softeng.booleval;

import gr.ntua.softeng.booleval.andortree.LeafNode;

import java.util.ArrayList;


public class Evaluation {

	public Evaluation(boolean result, double time, double minCost, double totalCost) {
		this.result = result;
		this.time = time;
		this.minCost = minCost;
		this.totalCost = totalCost;
	}
	
	ArrayList<LeafNode> usedLeaves = new ArrayList<LeafNode>();
	
	public ArrayList<LeafNode> getUsedLeaves() {
		return usedLeaves;
	}
	public void setUsedLeaves(ArrayList<LeafNode> usedLeaves) {
		this.usedLeaves = usedLeaves;
	}

	boolean result;
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public double getMinCost() {
		return minCost;
	}
	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	double time;
	double minCost;
	double totalCost;

	public String toString() {
		return "result: " + result + ", " +
				"time: " + time + ", " +
				"minCost: " + minCost + ", " +
				"totalCost: " + totalCost + "\tleaves used: " + leavesToString(usedLeaves);
//		return "" + result + "\t" +
//		"" + time + "\t" +
//		"" + minCost + "\t" +
//		"" + totalCost;
	}
	private String leavesToString(ArrayList<LeafNode> usedLeaves) {
		StringBuffer sb = new StringBuffer();
		for (LeafNode l : usedLeaves) {
			sb.append(l.getLabel() + "_" + l.getAnnotation() + " ");
		}
		return sb.toString().trim();
	}
	
}
