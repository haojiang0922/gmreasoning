package gr.ntua.softeng.gm.reasoning.wfr.components;


public class Comment extends WeightedFuzzyRule {

	private String comment;
	
	public Comment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getRule() {
		return "%" + comment;
	}

}
