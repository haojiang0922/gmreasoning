package gr.ntua.softeng.gtsat.goalmodel.rules;

import java.util.HashSet;
import java.util.Set;

public class GoalDecompositionRule {

	public static final int AND = 1;
	public static final int OR = 2;
	
	private String parentNodeKey;
	private Set<String> childNodeKeys = new HashSet<String>();
	private int type;
	
	public GoalDecompositionRule(String parentNodeKey, Set<String> childNodeKeys, int type) {
		this.parentNodeKey = parentNodeKey;
		this.childNodeKeys = childNodeKeys;
		this.type = type;
	}

	public String getParentNodeKey() {
		return parentNodeKey;
	}

	public Set<String> getChildNodeKeys() {
		return childNodeKeys;
	}
	
	public boolean isANDDecomposed() {
		return this.type == AND;
	}
	
	public boolean isORDecomposed() {
		return this.type == OR;
	}
	
	public void setParentNodeKey(String parentNodeKey) {
		this.parentNodeKey = parentNodeKey;
	}
}
