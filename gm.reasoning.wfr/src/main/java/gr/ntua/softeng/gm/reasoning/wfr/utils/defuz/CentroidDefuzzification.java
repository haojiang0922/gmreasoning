package gr.ntua.softeng.gm.reasoning.wfr.utils.defuz;

import java.util.ArrayList;
import java.util.List;

import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.HighMemFunc;
import gr.ntua.softeng.gm.reasoning.wfr.utils.memfunc.LowMemFunc;

/*
 * http://en.wikipedia.org/wiki/Centroid
 */
public class CentroidDefuzzification {

	private double xMin = 0.0;
	private double xMax = 100.0;
	
	private double yMin = 0.0;
	
	private LowMemFunc lowMemFunc;
	private HighMemFunc highMemFunc;
	
	// A null intersection means that the two mem functions do not intersect
	private Double memFuncIntersection = null;
	private Double yIntersection = null;
	
	public CentroidDefuzzification(LowMemFunc lowMemFunc, HighMemFunc highMemFunc) {
		this.lowMemFunc = lowMemFunc;
		this.highMemFunc = highMemFunc;
		//System.out.println("Zeros : lowMemFunc = " + lowMemFunc.getXForZero() + ", highMemFunc = " + highMemFunc.getXForZero());
		if (lowMemFunc.getXForZero() >= highMemFunc.getXForZero()) {
			// should solve equation : 
			// (d_L - x) / (d_L - c_L) = (x - a_H) / (b_H - a_H)
			this.memFuncIntersection = this.getMemFuncIntersection(lowMemFunc, highMemFunc);
			this.yIntersection = lowMemFunc.getValue(this.memFuncIntersection);
		}
		this.xMin = lowMemFunc.getA();
		this.xMax = highMemFunc.getD();
		//System.out.println("memFuncIntersection : " + memFuncIntersection);
	}
	
	private Double getMemFuncIntersection(LowMemFunc lowMemFunc, HighMemFunc highMemFunc) {
		double dLow = lowMemFunc.getD(), cLow = lowMemFunc.getC();
		double aHigh = highMemFunc.getA(), bHigh = highMemFunc.getB();
		return ( dLow * (bHigh - aHigh) + aHigh * (dLow - cLow) ) / (dLow - cLow + bHigh - aHigh);
	}
	
	public double getxMin() {
		return xMin;
	}
	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getxMax() {
		return xMax;
	}
	public void setxMax(double xMax) {
		this.xMax = xMax;
	}


	public double getDefuzValue(double lowValue, double highValue) {
		//TODO this is a work around, normally there should not be allowed tp
		// define polygons where two or more points are the same
		if (lowValue <= 0.0 && highValue <= 0.0) return 0.0;
		//
		List<Polygon> polygons = new ArrayList<>();
		if (this.memFuncIntersection!=null) {
			// The lower part rectangle
			double aMin = this.min(lowValue, highValue, this.yIntersection);
			//System.out.println("aMin : " + aMin);
			if (aMin > 0.0) {
				Polygon rectangle = new Polygon(new Point[] {
						new Point(xMin, yMin),
						new Point(xMax, yMin),
						new Point(xMax, aMin),
						new Point(xMin, aMin)
				});
				polygons.add(rectangle);
				//System.out.println("Rectangle : " + rectangle);
			}
			// The trapezoids (there might be 2 or 1 according to what the given values are)
			if (lowValue > aMin) {
				double xForMemFuncValue = this.lowMemFunc.getXForValue(lowValue);
				double xForMinValue = this.lowMemFunc.getXForValue(aMin);
				Polygon lowTrapezoid = new Polygon(new Point[] {
						new Point(xMin, aMin), 
						new Point(xForMinValue, aMin),
						new Point(xForMemFuncValue, lowValue),
						new Point(xMin, lowValue)
				});
				polygons.add(lowTrapezoid);
				//System.out.println("lowTrapezoid : " + lowTrapezoid);
			}
			if (highValue > aMin) {
				double xForMemFuncValue = this.highMemFunc.getXForValue(highValue);
				double xForMinValue = this.highMemFunc.getXForValue(aMin);
				Polygon highTrapezoid = new Polygon(new Point[] {
						new Point(xForMinValue, aMin), 
						new Point(xMax, aMin), 
						new Point(xMax, highValue), 
						new Point(xForMemFuncValue, highValue)
				});
				polygons.add(highTrapezoid);
				//System.out.println("highTrapezoid : " + highTrapezoid);
			}
		} else {
			// The trapezoids 
			if (lowValue > 0.0) {
				double xForLowMemFuncValue = this.lowMemFunc.getXForValue(lowValue);
				Polygon lowTrapezoid = new Polygon(new Point[] {
						new Point(xMin, yMin), 
						new Point(this.lowMemFunc.getD(), yMin),
						new Point(xForLowMemFuncValue, lowValue),
						new Point(xMin, lowValue)
				});
				polygons.add(lowTrapezoid);
				//System.out.println("lowTrapezoid : " + lowTrapezoid);
				
			}
			
			if (highValue > 0.0) {
				double xForHighMemFuncValue = this.highMemFunc.getXForValue(highValue);
				Polygon highTrapezoid = new Polygon(new Point[] {
						new Point(this.highMemFunc.getA(), yMin), 
						new Point(xMax, yMin),
						new Point(xMax, highValue),
						new Point(xForHighMemFuncValue, highValue)
				});
				polygons.add(highTrapezoid);
				//System.out.println("highTrapezoid : " + highTrapezoid);
			}
		}
		// http://en.wikipedia.org/wiki/Centroid
		double areaSum = 0.0, centroidSum = 0.0;
		for (Polygon polygon : polygons) {
			areaSum += polygon.getArea();
			centroidSum += polygon.getArea() * polygon.getxCentroid();
		}
		return centroidSum / areaSum;
	}
	
	private double min(double a, double b, double c) {
		double min = Math.min(a, b);
		min = Math.min(min, c);
		return min;
	}
		
}
