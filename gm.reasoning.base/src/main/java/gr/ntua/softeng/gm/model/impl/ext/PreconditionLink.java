package gr.ntua.softeng.gm.model.impl.ext;

import gr.ntua.softeng.gm.model.impl.AbstractBinaryRule;

public class PreconditionLink<T> extends AbstractBinaryRule<T> {

	public PreconditionLink(String source, String target) {
		super(source, target);
	}
}