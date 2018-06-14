package gr.ntua.softeng.gm.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObservableWeights {

	private Map<String,Integer> nodeWeights = new HashMap<String,Integer>();
	
	public void setNodeWeight(String nodeKey, int weight) {
		nodeWeights.put(nodeKey, weight);
	}
	
	public void updateNodeWeight(String nodeKey, int weight, UpdateHandler handler) {
		if(this.nodeWeights.containsKey(nodeKey)) {
			nodeWeights.put(nodeKey, weight);
			handler.onUpdate();
		} else {
			nodeWeights.put(nodeKey, weight);
		}	
	}
	
	public void updateNodeWeights(Map<String,Integer> newWeights, UpdateHandler handler) {
		boolean mapAltered = false;
		for (String nodeKey : newWeights.keySet()) {
			if(this.nodeWeights.containsKey(nodeKey)) {
				mapAltered = true;
			}
			Integer w = newWeights.get(nodeKey);
			nodeWeights.put(nodeKey, w);
		}
		if(mapAltered) {
			handler.onUpdate();
		}	
	}
	
	public Integer getNodeWeight(String nodeKey) {
		return this.nodeWeights.get(nodeKey);
	}
	
	public Set<String> nodeKeySet() {
		return this.nodeWeights.keySet();
	}
}
