package gr.ntua.softeng.gm.model.impl;

import java.util.Collection;

import gr.ntua.softeng.gm.model.comp.Component;
import gr.ntua.softeng.gm.model.rules.Decomposition;
import gr.ntua.softeng.gm.model.rules.DecompositionType;

public class DefaultDecompositionImpl<T> extends Component<T> implements Decomposition {

	private String parent;
	private Collection<String> childNodes;
	private DecompositionType type;
	
	public DefaultDecompositionImpl(String parent, Collection<String> childNodes, DecompositionType type) {
		this.parent = parent;
		this.childNodes = childNodes;
		this.type = type;
	}

	@Override
	public String getParent() {
		return parent;
	}

	public void setParentNode(String parent) {
		this.parent = parent;
	}

	public Collection<String> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(Collection<String> childNodes) {
		this.childNodes = childNodes;
	}

	public DecompositionType getType() {
		return type;
	}

	public void setType(DecompositionType type) {
		this.type = type;
	}

	@Override
	public String getConsequent() {
		return this.getParent();
	}
	
	@Override
	public Collection<String> getAntecedents() {
		return this.childNodes;
	}
	
	@Override
	public boolean isANDDecomposed() {
		return DecompositionType.AND.equals(this.type);
	}

}
