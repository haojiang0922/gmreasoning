package gr.ntua.softeng.gm.model.view.andor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import gr.ntua.softeng.gm.model.impl.ext.WeightedGoal;

public class AndOrRule {

	private String parentNodeKey;
	private Set<WeightedGoal> childNodes;
	private boolean isAndRule;
	
	public AndOrRule(String parentNodeKey, Set<WeightedGoal> childNodes, boolean isAndRule) {
		this.parentNodeKey = parentNodeKey;
		this.childNodes = childNodes;
		this.isAndRule = isAndRule;
	}

	public String getParentNodeKey() {
		return parentNodeKey;
	}

	public boolean isAndRule() {
		return isAndRule;
	}

	public Set<WeightedGoal> getChildNodes() {
		return childNodes;
	}
	
	public Set<String> getChildNodeKeys() {
		Set<String> keys = new HashSet<String>();
		for (WeightedGoal n : this.childNodes) {
			keys.add(n.getId());
		}
		return keys;
	}
	
	/**
	 * Use common JEXL syntax
	 * [http://commons.apache.org/proper/commons-jexl/reference/syntax.html]
	 */
	public String getJexlExpression() {
		StringBuilder buffer = new StringBuilder();
		String operator = "||";
		if (this.isAndRule()) operator = "&&";
		Iterator<WeightedGoal> nodeIter = this.childNodes.iterator();
		while (nodeIter.hasNext()) {
			WeightedGoal n = nodeIter.next();
			if (n.getIsInverse()) buffer.append("!");
			buffer.append(n.getId());
			if (nodeIter.hasNext()) {
				buffer.append(" ").append(operator).append(" ");
			}	
		}
		return buffer.toString();
	}
}
