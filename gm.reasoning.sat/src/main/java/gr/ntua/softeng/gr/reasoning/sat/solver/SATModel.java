package gr.ntua.softeng.gr.reasoning.sat.solver;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SATModel implements ISATModel {

	private Map<String, Boolean> nodeValues;
	private Map<String, Boolean> leafValues;
	
	public SATModel(Map<String, Boolean> nodeValues, Map<String, Boolean> leafValues) {
		this.nodeValues = nodeValues;
		this.leafValues = leafValues;
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
	
	public Map<String, Boolean> getNodeValues() {
		return this.nodeValues;
	}
	
	public Map<String, Boolean> getLeafValues() {
		return this.leafValues;
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
