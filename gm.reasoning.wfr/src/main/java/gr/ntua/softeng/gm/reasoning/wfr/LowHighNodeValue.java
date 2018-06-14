package gr.ntua.softeng.gm.reasoning.wfr;

import gr.ntua.softeng.gm.reasoning.Value;

public class LowHighNodeValue implements Value {

	private Double low;
	private Double high;
	
	public LowHighNodeValue() {
		this(0.0, 0.0);
	}
	
	public LowHighNodeValue(Double low, Double high) {
		this.low = low;
		this.high = high;
	}
	
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}	
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("HIGH = ").append(this.high).append(", LOW = ").append(this.low);
		return buffer.toString();
	}
	
}
