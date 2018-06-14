package gr.ntua.softeng.gm.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gr.ntua.softeng.gm.model.comp.Component;
import gr.ntua.softeng.gm.model.rules.BinaryRule;

public abstract class AbstractBinaryRule<T> extends Component<T> implements BinaryRule {

	private String source;
	private String target;
	
	public AbstractBinaryRule(String source, String target) {
		this.source = source;
		this.target = target;
	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public String getTarget() {
		return this.target;
	}

	@Override
	public String getConsequent() {
		return this.target;
	}

	@Override
	public Collection<String> getAntecedents() {
		List<String> antecedents = new ArrayList<>();
		antecedents.add(this.source);
		return antecedents;
	}

}
