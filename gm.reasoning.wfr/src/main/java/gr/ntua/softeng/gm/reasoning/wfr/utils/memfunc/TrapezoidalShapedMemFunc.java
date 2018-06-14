package gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc;

/*
 * http://www.mathworks.com/help/fuzzy/trapmf.html
 */
public abstract class TrapezoidalShapedMemFunc {

	private Integer a,b,c,d;
	
	public TrapezoidalShapedMemFunc(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public double getValue(double x) {
		double value = 0;
		if (x>=a && x<b) {
			value = (x - a * 1.0) / (b * 1.0 - a * 1.0);
		} else if (x>=b && x<c) {
			value = 1.0;
		} else if (x>=c && x<d) {
			value = (d * 1.0 - x) / (d * 1.0 - c * 1.0);
		}
		return value;
	}

	public Integer getA() {
		return a;
	}

	public Integer getB() {
		return b;
	}

	public Integer getC() {
		return c;
	}

	public Integer getD() {
		return d;
	}
	
	public abstract double getXForZero();
	
	public abstract double getXForValue(double value);
	
}
