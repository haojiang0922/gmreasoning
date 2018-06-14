package gr.ntua.softeng.gtsat;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SATModel {

	private Map<String, Boolean> nodeValues;
	
	public SATModel(Map<String, Boolean> nodeValues) {
		this.nodeValues = nodeValues;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Model : \n");
		this.addAssignments(buffer);
		this.addValues(buffer);
		return buffer.toString();
	}
	
	private void addAssignments(StringBuilder buffer) {
		Set<String> nodeKeys = new TreeSet<String>(nodeValues.keySet());
		Iterator<String> nodeKeysIter = nodeKeys.iterator();
		buffer.append("\t").append("assignment: [");
		while (nodeKeysIter.hasNext()) {
			String key = (String) nodeKeysIter.next();
			buffer.append(nodeValues.get(key));
			if (nodeKeysIter.hasNext()) {
				buffer.append(", ");
			}
		}
		buffer.append("]\n");
	}
	
	private void addValues(StringBuilder buffer) {
		Set<String> nodeKeys = new TreeSet<String>(nodeValues.keySet());
		Iterator<String> nodeKeysIter = nodeKeys.iterator();
		buffer.append("\t").append("values : {");
		while (nodeKeysIter.hasNext()) {
			String key = (String) nodeKeysIter.next();
			buffer.append(key).append("=").append(nodeValues.get(key));
			if (nodeKeysIter.hasNext()) {
				buffer.append(", ");
			}
		}
		buffer.append("}\n");
	}
	
	public Map<String, Boolean> getNodeValuePairs() {
		return this.nodeValues;
	}
	
	public Set<String> getTrueNodeKeys() {
		Set<String> trueNodeKeys = new TreeSet<String>();
		for (String nodeKey : this.nodeValues.keySet()) {
			if (this.nodeValues.get(nodeKey)) {
				trueNodeKeys.add(nodeKey);
			}
		}
		return trueNodeKeys;
	}
}
