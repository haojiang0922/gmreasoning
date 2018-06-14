package gr.ntua.softeng.gtsat.cnf;

public class Clause extends AbstractClause {

	@Override
	public boolean isHard() {
		return true;
	}

	@Override
	public int getWeight() {
		throw new UnsupportedOperationException();
	}
	
}