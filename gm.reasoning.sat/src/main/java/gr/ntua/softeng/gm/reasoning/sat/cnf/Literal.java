package gr.ntua.softeng.gm.reasoning.sat.cnf;

public class Literal {

	private boolean isNegated;
	private Atom atom;
	
	public Literal(Atom atom, boolean isNegated) {
		this.atom = atom;
		this.isNegated = isNegated;
	}
		
	public boolean isNegated() {
		return isNegated;
	}
	
	public void setIsNegated(boolean isNegated) {
		this.isNegated = isNegated;
	}
	
	public void invert() {
		isNegated = isNegated ? false : true;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		if(isNegated) {
			buffer.append("~");
		} 
		buffer.append(this.atom);
		return buffer.toString();
	}

	public Atom getAtom() {
		return atom;
	}
	
	public void setAtom(Atom a) {
		this.atom = a;
	}
	
	public int getLiteralCode() {
		return this.getId() * (this.isNegated ? -1 : 1);
	}
	
	public int getId() {
		return this.atom.getId();
	}
}
