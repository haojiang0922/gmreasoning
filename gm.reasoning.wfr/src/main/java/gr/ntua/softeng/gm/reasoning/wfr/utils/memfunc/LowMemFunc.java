package gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc;

public class LowMemFunc extends TrapezoidalShapedMemFunc {

	public LowMemFunc(int a, int b) {
		super(0, 0, a, b);
	}

	@Override
	public double getXForZero() {
		return this.getD() * 1.0;
	}

	@Override
	public double getXForValue(double value) {
		return this.getD() * 1.0 - value * (this.getD() * 1.0 - this.getC() * 1.0);
	}
	
}
