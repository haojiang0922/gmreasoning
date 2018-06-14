package gr.ntua.softeng.gm.model.impl.ext;

import gr.ntua.softeng.gm.model.impl.AbstractBinaryRule;

public class PrecedenceLink<T> extends AbstractBinaryRule<T> {

	public PrecedenceLink(String source, String target) {
		super(source, target);
	}
}
