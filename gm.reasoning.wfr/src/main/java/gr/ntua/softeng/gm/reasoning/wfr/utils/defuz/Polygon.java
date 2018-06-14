package gr.ntua.softeng.gm.reasoning.wfr.utils.defuz;

import java.util.HashSet;
import java.util.Set;


public class Polygon {
	
	private Point[] points;
	
	private double area = 0.0, xCentroid = 0.0;
	
	public Polygon(Point... points) {
		if (points.length < 3) {
			throw new IllegalArgumentException();
		}
		this.points = new Point[points.length+1];
		for (int i=0; i<points.length; i++) {
			this.points[i] = points[i];
		}
		this.points[points.length] = points[0];
		this.calculatePolygonXCentroidAndArea();
	}
			
	//http://en.wikipedia.org/wiki/Polygon
	private void calculatePolygonXCentroidAndArea() {
		for (int i=0; i<points.length-1; i++) {
			double tmp = (points[i].x * points[i+1].y) - (points[i+1].x * points[i].y);
			area += tmp;
			xCentroid += (points[i].x + points[i+1].x) * tmp;
		}
		area = 0.5 * Math.abs(area);
		xCentroid = xCentroid / (6.0 * area);
	}

	public double getArea() {
		return area;
	}

	public double getxCentroid() {
		return xCentroid;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("{");
		for (Point p: this.points) {
			buffer.append("(").append(p.x).append(", ").append(p.y).append(") ");
		}
		buffer.append("}\n Area: ").append(this.area).append(", Cx: ").append(this.xCentroid);
		return buffer.toString();
	}

}
