package gr.ntua.softeng.gm.reasoning.wfr;

import gr.ntua.softeng.gm.reasoning.wfr.utils.defuz.CentroidDefuzzification;
import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.HighMemFunc;
import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.LowMemFunc;

public class LowHighValueHelper {

	private LowMemFunc lowMemFunc;
	private HighMemFunc highMemFunc;
	private CentroidDefuzzification defuz;
	
	public LowHighValueHelper(LowMemFunc lowMemFunc, HighMemFunc highMemFunc) {
		this.highMemFunc = highMemFunc;
		this.lowMemFunc = lowMemFunc;
		this.defuz = new CentroidDefuzzification(lowMemFunc, highMemFunc);
	}
	
	public LowHighNodeValue getValue(double satisfactionDegree) {
		double lowValue  = this.lowMemFunc.getValue(satisfactionDegree);
		double highValue = this.highMemFunc.getValue(satisfactionDegree);
		return new LowHighNodeValue(lowValue, highValue);
	}
	
	public double getSatisfactionDegree(LowHighNodeValue value) {
		return this.defuz.getDefuzValue(value.getLow(), value.getHigh());
	}
}
