package gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc;

public class HighMemFunc extends TrapezoidalShapedMemFunc {

	public HighMemFunc(int a, int b) {
		super(b, a, 100, 100);
	}

	@Override
	public double getXForZero() {
		return this.getA() * 1.0;
	}
	
	@Override
	public double getXForValue(double value) {
		return this.getA() * 1.0 + value * (this.getB() * 1.0 - this.getA() * 1.0);
	}

	@Override
	public double getValue(double x) {
		double value = 1.0;
		if (x<100) {
			value = super.getValue(x);
		}
		return value;
	}
}
