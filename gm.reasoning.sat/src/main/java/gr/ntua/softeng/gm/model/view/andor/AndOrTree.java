package gr.ntua.softeng.gm.model.view.andor;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gr.ntua.softeng.gm.model.GoalModelAbstraction;
import gr.ntua.softeng.gm.model.impl.ext.PreconditionLink;
import gr.ntua.softeng.gm.model.impl.ext.WeightedGoal;
import gr.ntua.softeng.gm.model.rules.Contribution;
import gr.ntua.softeng.gm.model.rules.Decomposition;

public class AndOrTree {

	private static final String PSEUDO_NODE_IDENTIFIER = "PSEUDO";
	private static final String DECOMPOSITION_PSEUDO_NODE_SUFFIX = "_d";
	private static final String CONTRIBUTION_PSEUDO_NODE_SUFFIX = "_c";
	private static final String LEAF_PSEUDO_NODE_SUFFIX = "_leaf";
	private static final String PRE_LEAF_PSEUDO_NODE_SUFFIX = "_pre_leaf";
	private static final String PRE_PSEUDO_NODE_SUFFIX = "_pre";
	private static final String POS_CONTRIBUTION_PSEUDO_NODE_SUFFIX = "_c_pos";
	private static final String NEG_CONTRIBUTION_PSEUDO_NODE_SUFFIX = "_c_neg";
	
	// the and/or rules that correspond to the given goal tree
	private Map<String,AndOrRule> andOrRules = new HashMap<String,AndOrRule>();
	
	private Map<String,WeightedGoal> nodes = new HashMap<String,WeightedGoal>();
	
	public AndOrTree(GoalModelAbstraction gm) {
		this.initializeAndOrRules(gm.getDecompositionRules());
		this.processPreconditionLinks(gm.getPreconditionRules());
		Map<String,Set<Contribution>> posContrRules = new HashMap<String,Set<Contribution>>(gm.getPosContributionRules());
		Map<String,Set<Contribution>> negContrRules = new HashMap<String,Set<Contribution>>(gm.getNegContributionRules());
		this.processDecompositionsContributions(posContrRules, negContrRules);
	}

	private void initializeAndOrRules(Set<Decomposition> decompRules) {
		for (Decomposition decompositionRule : decompRules) {
			AndOrRule rule = this.createAndOrRule(decompositionRule);
			this.andOrRules.put(decompositionRule.getParent(), rule);
		}
	}
	
	private WeightedGoal createOrGetNode(String nodeKey) {
		WeightedGoal node = this.nodes.get(nodeKey);
		if (node == null) {
			node = new WeightedGoal(nodeKey);
			this.nodes.put(nodeKey, node);
		}
		return node;
	}
	
	private Set<WeightedGoal> createChildNodeSet(Collection<String> nodeKeys) {
		Set<WeightedGoal> nodeSet = new HashSet<WeightedGoal>();
		for (String key : nodeKeys) {
			nodeSet.add(this.createOrGetNode(key));
		}
		return nodeSet;
	}
	
	private void renameNode(String nodeName, String newName) {
		WeightedGoal n = this.nodes.remove(nodeName);
		if (n == null) {
			throw new IllegalArgumentException("Node does not exist!");
		}
		n.setId(newName);
		this.nodes.put(newName, n);
		// also add a new instance of the previous node
		WeightedGoal node = new WeightedGoal(nodeName);
		this.nodes.put(nodeName, node);
	}
	
	private String pseudoNodeKey(String nodeKey, String suffix) {
		return nodeKey + PSEUDO_NODE_IDENTIFIER + suffix;
	}
	
	public Collection<AndOrRule> getRules() {
		return this.andOrRules.values();
	}
	
	public Map<String,AndOrRule> getRulesMap() {
		return this.andOrRules;
	}
	
	private void addOrRule(String parentNodeKey, Set<String> childNodeKeys) {
		this.addAndOrRule(parentNodeKey, childNodeKeys, false);
	}
	
	private void addAndRule(String parentNodeKey, Set<String> childNodeKeys) {
		this.addAndOrRule(parentNodeKey, childNodeKeys, true);
	}
	
	private void addOrRule(String parentNodeKey, String... childNodeKeys) {
		Set<String> childNodeKeySet = new HashSet<String>();
		for (String nodeKey : childNodeKeys) {
			childNodeKeySet.add(nodeKey);
		}
		this.addOrRule(parentNodeKey, childNodeKeySet);
	}
	
	private void addAndRule(String parentNodeKey, String[] posChildNodeKeys, String[] negChildNodeKeys) {
		Set<String> posChildNodeKeySet = new HashSet<String>();
		for (String k : posChildNodeKeys) {
			posChildNodeKeySet.add(k);
		}
		Set<String> negChildNodeKeySet = new HashSet<String>();
		for (String k : negChildNodeKeys) {
			negChildNodeKeySet.add(k);
		}
		AndOrRule rule = this.createAndOrRule(parentNodeKey, posChildNodeKeySet, negChildNodeKeySet, true);
		this.andOrRules.put(parentNodeKey, rule);
	}
	
	private void addAndOrRule(String parentNodeKey, Set<String> childNodeKeys, boolean isAndRule) {
		AndOrRule rule = this.createAndOrRule(parentNodeKey, childNodeKeys, isAndRule);
		this.andOrRules.put(parentNodeKey, rule);
	}
	
	private AndOrRule createAndOrRule(String parentNodeKey, Collection<String> childNodeKeys, boolean isAndRule) {
		Set<WeightedGoal> childNodes = this.createChildNodeSet(childNodeKeys);
		return new AndOrRule(parentNodeKey, childNodes, isAndRule);
	}

	private AndOrRule createAndOrRule(String parentNodeKey, Set<String> posChildNodeKeys, Set<String> negChildNodeKeys, boolean isAndRule) {
		Set<WeightedGoal> childNodes = this.createChildNodeSet(posChildNodeKeys);
		Set<WeightedGoal> negChildNodes = this.createChildNodeSet(negChildNodeKeys);
		for (WeightedGoal node : negChildNodes) {
			node.setIsInverse(true);
		}
		childNodes.addAll(negChildNodes);
		return new AndOrRule(parentNodeKey, childNodes, isAndRule);
	}
	
	private AndOrRule createAndOrRule(Decomposition decompositionRule) {
		return this.createAndOrRule(decompositionRule.getParent(), decompositionRule.getChildNodes(), decompositionRule.isANDDecomposed());
	}
	
	private Set<String> extractSourcesOfPreRules(Set<PreconditionLink<?>> rules) {
		Set<String> sourceNodeKeys = new HashSet<String>();
		for (PreconditionLink<?> preRule : rules) {
			sourceNodeKeys.add(preRule.getSource());
		}
		return sourceNodeKeys;
	}
	
	private Set<String> extractSourcesOfContrRule(Set<Contribution> rules) {
		Set<String> sourceNodeKeys = new HashSet<String>();
		for (Contribution contrRule : rules) {
			sourceNodeKeys.add(contrRule.getSource());
		}
		return sourceNodeKeys;
	}
	
	/**
	 * {n_a1,n_a2,...,n_ak} --[pre]--> n_b :
	 * 	A. n_b is NOT a leaf node (i.e. n_b is AND/OR decomposed), let n_b<-OR(i1,...,in)/n_b<-AND(i1,...,in)
	 * 		1. n_b_pre <-OR(i1,...,in)/n_b_pre <-AND(i1,...,in)
	 * 		2. n_b <-AND(n_a1,n_a2,...,n_ak,n_b_pre)
	 * 	B. n_b is a LEAF node
	 * 		1. n_b_pre_leaf <-AND(n_a1,n_a2,...,n_ak,n_b)
	 */
	private void processPreconditionLinks(Map<String,Set<PreconditionLink<?>>> preRules) {
		for (Entry<String,Set<PreconditionLink<?>>> entry : preRules.entrySet()) {
			String node = entry.getKey();
			AndOrRule currentRule = this.andOrRules.remove(node);
			if (currentRule != null) {
				// 1. n_b_pre<-OR(i1,...,in)/n_b_pre<-AND(i1,...,in)
				String node_pre = this.pseudoNodeKey(node, PRE_PSEUDO_NODE_SUFFIX);
				this.addAndOrRule(node_pre, currentRule.getChildNodeKeys(), currentRule.isAndRule());
				// 2. n_b<-AND(n_a1,n_a2,...,n_ak,n_b_pre)
				Set<String> childNodeKeys = this.extractSourcesOfPreRules(entry.getValue());
				childNodeKeys.add(node_pre);
				this.addAndRule(node, childNodeKeys);
			} else {
				String node_pre_leaf = this.pseudoNodeKey(node, PRE_LEAF_PSEUDO_NODE_SUFFIX);
				// 1. n_b_pre_leaf <-AND(n_a1,n_a2,...,n_ak,n_b)
				Set<String> childNodeKeys = this.extractSourcesOfPreRules(entry.getValue());
				childNodeKeys.add(node);
				this.addAndRule(node_pre_leaf, childNodeKeys);
				// change n_b leaf node name to n_b_pre_leaf
				this.renameNode(node, node_pre_leaf);
			}
		}
	}
	
	private void processDecompositionsContributions(Map<String,Set<Contribution>> posContrRules, Map<String,Set<Contribution>> negContrRules) {
		this.processDecompositions(posContrRules, negContrRules);
		// Handle leaf nodes that are the target node of contributions
		this.processContributions(posContrRules, negContrRules);
	}
	
	private void processDecompositions(Map<String,Set<Contribution>> posContrRules, Map<String,Set<Contribution>> negContrRules) {
		Map<String,AndOrRule> tempRules = new HashMap<String,AndOrRule>(this.andOrRules);
		this.andOrRules.clear();
		Set<String> decompNodeKeys = tempRules.keySet();
		for (String node : decompNodeKeys) {
			AndOrRule currentRule = tempRules.get(node);
			Set<Contribution> posContr = posContrRules.remove(node);
			Set<Contribution> negContr = negContrRules.remove(node);
			if (posContr!=null && negContr!=null) {
				/*
				 * O<-AND(i1,...,in)/O<-OR(i1,...,in) =>
				 * 1. O<-OR(O_d,O_c)
				 * 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				 * 3. O_c<-AND(a_c_pos, NOT a_c_neg)
				 * 4. a_c_pos<-OR(sources of all ++S/--D contributions)
				 * 5. a_c_neg<-OR(sources of all --S/++D contributions)
				 */
				// 1. O<-OR(O_d,O_c)
				String node_d = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				this.addOrRule(node, new String[] {node_d, node_c});
				// 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				this.addAndOrRule(node_d, currentRule.getChildNodeKeys(), currentRule.isAndRule());
				// 3. O_c<-AND(a_c_pos, NOT a_c_neg)
				String node_c_pos = this.pseudoNodeKey(node, POS_CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				String node_c_neg = this.pseudoNodeKey(node, NEG_CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				this.addAndRule(node_c, new String[] {node_c_pos}, new String[] {node_c_neg});
				// 4. a_c_pos<-OR(sources of all ++S/--D contributions)
				this.addOrRule(node_c_pos, this.extractSourcesOfContrRule(posContr));
				// 5. a_c_neg<-OR(sources of all --S/++D contributions)
				this.addOrRule(node_c_neg, this.extractSourcesOfContrRule(negContr));
			} else if (posContr!=null) {
				/*
				 * O<-AND(i1,...,in)/O<-OR(i1,...,in) =>
				 * 1. O<-OR(O_d,O_c)
				 * 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				 * 3. O_c<-OR(sources of all ++S/--D contributions)
				 */
				// 1. O<-OR(O_d,O_c)
				String node_d = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				this.addOrRule(node, new String[] {node_d, node_c});
				// 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				this.addAndOrRule(node_d, currentRule.getChildNodeKeys(), currentRule.isAndRule());
				// 3. O_c<-OR(sources of all ++S/--D contributions)
				this.addOrRule(node_c, this.extractSourcesOfContrRule(posContr));
			} else if (negContr!=null) {
				/*
				 * O<-AND(i1,...,in)/O<-OR(i1,...,in) =>
				 * 1. O<-AND(O_d, NOT O_c)
				 * 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				 * 3. O_c<-OR(sources of all --S/++D contributions)
				 */
				// 1. O<-AND(O_d, NOT O_c)
				String node_d = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				this.addAndRule(node, new String[] {node_d}, new String[] {node_c});
				// 2. O_d<-AND(i1,...,in)/O_d<-OR(i1,...,in)
				this.addAndOrRule(node_d, currentRule.getChildNodeKeys(), currentRule.isAndRule());
				// 3. O_c<-OR(sources of all --S/++D contributions)
				this.addOrRule(node_c, this.extractSourcesOfContrRule(negContr));
			} else {
				this.andOrRules.put(node,currentRule);
			}
		}
	}
	
	private void processContributions(Map<String,Set<Contribution>> posContrRules, Map<String,Set<Contribution>> negContrRules) {
		Set<String> allContrKeys = new HashSet<String>();
		allContrKeys.addAll(posContrRules.keySet());
		allContrKeys.addAll(negContrRules.keySet());
		for (String node : allContrKeys) {
			Set<Contribution> posContr = posContrRules.remove(node);
			Set<Contribution> negContr = negContrRules.remove(node);
			if (posContr!=null && negContr!=null) {
				/*
				 * L is a leaf node =>
				 * 1. L_leaf<-OR(L,O_c)
				 * 2. O_c<-AND(a_c_pos, NOT a_c_neg)
				 * 3. a_c_pos<-OR(sources of all ++S/--D contributions)
				 * 4. a_c_neg<-OR(sources of all --S/++D contributions)
				 */
				// 1. L_leaf<-OR(L,O_c)
				String node_leaf = this.pseudoNodeKey(node, LEAF_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				this.addOrRule(node_leaf, new String[] {node, node_c});
				// 2. O_c<-AND(a_c_pos, NOT a_c_neg)
				String node_c_pos = this.pseudoNodeKey(node, POS_CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				String node_c_neg = this.pseudoNodeKey(node, NEG_CONTRIBUTION_PSEUDO_NODE_SUFFIX);
				this.addAndRule(node_c, new String[] {node_c_pos}, new String[] {node_c_neg});
				// 3. a_c_pos<-OR(sources of all ++S/--D contributions)
				this.addOrRule(node_c_pos, this.extractSourcesOfContrRule(posContr));
				// 4. a_c_neg<-OR(sources of all --S/++D contributions)
				this.addOrRule(node_c_neg, this.extractSourcesOfContrRule(negContr));
			} else if (posContr!=null) {
				/*
				 * L is a leaf node =>
				 * 1. L_leaf<-OR(L,O_c)
				 * 2. O_c<-OR(sources of all ++S/--D contributions)
				 */
				// 1. L_leaf<-OR(L,O_c)
				String node_leaf = this.pseudoNodeKey(node, LEAF_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				this.addOrRule(node_leaf, new String[] {node, node_c});
				// 2. O_c<-OR(sources of all ++S/--D contributions)
				this.addOrRule(node_c, this.extractSourcesOfContrRule(posContr));
			} else if (negContr!=null) {
				/*
				 * L is a leaf node =>
				 * 1. L_leaf<-AND(L,NOT O_c)
				 * 2. O_c<-OR(sources of all --S/++D contributions)
				 */
				// 1. L_leaf<-AND(L,NOT O_c)
				String node_leaf = this.pseudoNodeKey(node, LEAF_PSEUDO_NODE_SUFFIX);
				String node_c = this.pseudoNodeKey(node, DECOMPOSITION_PSEUDO_NODE_SUFFIX);
				this.addAndRule(node_leaf, new String[] {node}, new String[] {node_c});
				// 2. O_c<-OR(sources of all --S/++D contributions)
				this.addOrRule(node_c, this.extractSourcesOfContrRule(negContr));
			}
		}
	}
	
	public static boolean isPseudoNode(String nodeKey) {
		return nodeKey != null && nodeKey.contains(PSEUDO_NODE_IDENTIFIER);
	}
}
