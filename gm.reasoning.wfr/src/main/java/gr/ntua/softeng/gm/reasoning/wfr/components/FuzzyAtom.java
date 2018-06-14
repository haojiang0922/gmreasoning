package gr.ntua.softeng.gm.reasoning.wfr.components;

public class FuzzyAtom {

	protected String predicateName;
	protected String variable;
	
	public FuzzyAtom(String predicateName, String variable) {
		super();
		this.predicateName = predicateName;
		this.variable = variable;
	}

	public String toString(){
		StringBuilder buffer = new StringBuilder();
		buffer.append(predicateName).append(variable);
		buffer.append("(_x)");
		return buffer.toString();
	}
	
	public String toStringWithSomeVariable(){
		StringBuilder buffer = new StringBuilder();
		buffer.append(predicateName).append(variable);
		buffer.append("(a)");
		return buffer.toString();
	}
}
