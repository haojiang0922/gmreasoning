package gr.ntua.softeng.gm.reasoning.sat.cnf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import gr.ntua.softeng.gm.model.ConstraintRule;
import gr.ntua.softeng.gm.model.GoalModelAbstraction;
import gr.ntua.softeng.gm.model.impl.ext.WeightedGoal;
import gr.ntua.softeng.gm.model.view.andor.AndOrRule;
import gr.ntua.softeng.gm.model.view.andor.AndOrTree;
import gr.ntua.softeng.gr.reasoning.sat.solver.ISATModel;
import gr.ntua.softeng.gr.reasoning.sat.solver.SATModel;
import gr.ntua.softeng.gr.reasoning.sat.solver.SatCNFFormula;

public class SatCNFWrapper<A extends Atom, L extends Literal, C extends Clause> implements SatCNFFormula {
	
	/*
	 *  Efficient Translation of Boolean Formulas to CNF in Formal Verification of Microprocessors
	 *  @inproceedings{DBLP:conf/aspdac/Velev04,
  	 *		author    = {Miroslav N. Velev},
  	 *		title     = {Efficient translation of boolean formulas to CNF in formal
     *		verification of microprocessors},
  	 *		booktitle = {ASP-DAC},
  	 *		year      = {2004},
  	 *		pages     = {310-315},
  	 *		ee        = {http://doi.acm.org/10.1145/1015090.1015164},
	 *	}
	 */
	
	private Map<String,A> nodeKey2AtomMap = new HashMap<String, A>();
	private Map<Integer,String> atomID2NodeKeyMap = new HashMap<Integer, String>();
		
	// The CNF formula
	private ArrayList<C> clauses = new ArrayList<>();
	// Constraints that can be dynamically updated
	private Map<String,C> constraints = new HashMap<>();
	
	private final CNFComponentFactory<A, L, C> compFactory;
	
	private Set<String> independentVariables;
	
	private int numOfLiterals = 0;
	
	public SatCNFWrapper(GoalModelAbstraction goalModel, CNFComponentFactory<A, L, C> compFactory) {
		this.compFactory = compFactory;
		this.parseRules(goalModel.getRules());
		this.parseConstraints(goalModel.getConstraints());
		// Update literals lists for all atoms in the formula
		// TODO find a better way to do this - the lists should be updated when literals are created
		// however in method "getORGateClauses" we create clones of the initial literal that are used 
		// in the CNF formula
		// Hence, the initial literal is in the atom's lists but it does not appear in the CND formula
		this.updateAtomsLists();
		// Update atoms' ids
		this.updateAtomsIds();
		this.independentVariables = goalModel.getLeafNodeKeys();
	}
	
	private void updateAtomsIds() {
		int atomCounter = 0;
		Set<String> sortedNodeKeysSet = new TreeSet<String>();
		sortedNodeKeysSet.addAll(this.nodeKey2AtomMap.keySet());
		for (String nodeKey : sortedNodeKeysSet) {
			this.atomID2NodeKeyMap.put(++atomCounter, nodeKey);
			// Also update the corresponding Atom object
			Atom a = this.nodeKey2AtomMap.get(nodeKey);
			a.setId(atomCounter);
		}
	}
	
	// TODO this method must be removed : 
	// literals' lists can be updated each time a new literal is created
	private void updateAtomsLists() {
		numOfLiterals = 0;
		for (C c : this.clauses) {
			for (Literal l : c.getLiterals()) {
				numOfLiterals++;
				if(l.isNegated()) {
					l.getAtom().addNegativeLiteral(l);
					if ( c.isHard() ) l.getAtom().addNegativeClause(c);
				} else {
					l.getAtom().addPositiveLiteral(l);
					if ( c.isHard() ) l.getAtom().addPositiveClause(c);
				}
			}
		}
	}
	
	// Composite Rules
	private void parseRules(Collection<AndOrRule> rules) {
		for (AndOrRule r : rules) {
			this.updateFormula(r.getParentNodeKey(), r.getChildNodes(), r.isAndRule());
		}
	}
	
	private void updateFormula(String parentNodeKey, Collection<WeightedGoal> childNodes, boolean isANDDecomposed) {
		ArrayList<C> decompositionClauses = null;
		// Get decomposition details
		L parentNodeLiteral = this.createLiteral(parentNodeKey, false);
		Set<L> childNodeLiterals = new HashSet<L>();
		for (WeightedGoal cn : childNodes) {
			L lit = this.createLiteral(cn.getId(), cn.getIsInverse());
			childNodeLiterals.add(lit);
		}
		// Create clauses
		if (isANDDecomposed) {
			decompositionClauses = this.getANDGateClauses(parentNodeLiteral, childNodeLiterals);
		} else {
			decompositionClauses = this.getORGateClauses(parentNodeLiteral, childNodeLiterals);
		}
		this.addAllClauses(decompositionClauses);
	}
			
	// O <- AND(i1,i2...,in)
	// (i1 V ~O) ^
	// (i2 V ~O) ^
	// ...
	// (in V ~O) ^
	// (~i1 V ~i2 V ... V ~in V O)
	private ArrayList<C> getANDGateClauses(L outputLiteral, Set<L> inputs) {
		ArrayList<C> allClauses = new ArrayList<C>();
			
		C clause = this.compFactory.createClause();		
		for (L i : inputs) {
			L inputLiteralNeg = this.compFactory.createNegatedLiteral(i);
			// every literal should be a different object even if it corresponds to the same atom (or its negation)
			L outputLiteralNeg = this.compFactory.createNegatedLiteral(outputLiteral);
			// term clause
			C termClause = this.compFactory.createClause();
			termClause.addLiteral(i);
			termClause.addLiteral(outputLiteralNeg);
			allClauses.add(termClause);
			//
			clause.addLiteral(inputLiteralNeg);
		}
		clause.addLiteral(outputLiteral);
		allClauses.add(clause);
		return allClauses;
	}
	
	// O <- OR(i1,i2...,in)
	// (~i1 V O) ^
	// (~i2 V O) ^
	// ...
	// (~in V O) ^
	// (i1 V i2 V ... V in V ~O)
	private ArrayList<C> getORGateClauses(L outputLiteral, Set<L> inputs) {
		ArrayList<C> allClauses = new ArrayList<C>();
		
		C clause = this.compFactory.createClause();		
		for (L i : inputs) {
			L inputLiteralNeg = this.compFactory.createNegatedLiteral(i);
			// every literal should be a different object even if it corresponds to the same atom (or its negation)
			L outputLiteralClone = this.compFactory.createLiteral(outputLiteral);
			// term clause
			C termClause = this.compFactory.createClause();
			termClause.addLiteral(inputLiteralNeg);
			termClause.addLiteral(outputLiteralClone);
			allClauses.add(termClause);
			//
			clause.addLiteral(i);
		}
		
		L outputLiteralNeg = this.compFactory.createNegatedLiteral(outputLiteral);
		
		clause.addLiteral(outputLiteralNeg);
		allClauses.add(clause);
		return allClauses;
	}
	
	// Constraints
	private void parseConstraints(Set<ConstraintRule> rules) {
		for (ConstraintRule r : rules) {
			this.updateFormula(r);
		}
	}
	
	private void updateFormula(ConstraintRule rule) {
		C clause = this.createGoalNodeClause(rule, !rule.getValue());
		this.addClause(clause);
	}
		
	private C createGoalNodeClause(ConstraintRule rule, boolean isNegated) {
		C c = this.compFactory.createClause();
		L lit = this.createLiteral(rule.getName(), isNegated);
		c.addLiteral(lit);
		return c;
	}
			
	public int getNumOfClauses() {
		return this.clauses.size();
	}

	public int getNumOfLiterals() {
		return numOfLiterals;
	}
	
	public List<int[]> getClausesInDIMACS() {
		List<int[]> clausesInDIMACS = new ArrayList<int[]>(this.getNumOfClauses());
		for (C c : this.clauses) {
			int[] clause = c.getDIMACSFormat();
			clausesInDIMACS.add(clause);
		}
		for (C c : this.constraints.values()) {
			int[] clause = c.getDIMACSFormat();
			clausesInDIMACS.add(clause);
		}
		return clausesInDIMACS;
	}

	public ArrayList<C> getClauses() {
		return this.clauses;
	}
	
	public int getNumOfAtoms() {
		return this.nodeKey2AtomMap.size();
	}
	
	protected void translateDIMACSModel(int[] model, Map<String, Boolean> nodeValues, Map<String, Boolean> leafValues) {
		if (nodeValues==null || leafValues==null) throw new IllegalArgumentException();
		for (int literalID : model) {
			String key = this.getNodeKeyForLiteralID(literalID);
			if (key != null  && !AndOrTree.isPseudoNode(key)) {
				Boolean value = literalID > 0 ? true : false;
				nodeValues.put(key, value);
				if (this.independentVariables.contains(key)) {
					leafValues.put(key, value);
				}
			}
		}
	}
	
	protected void getAtomValues(int[] model, Map<A, Boolean> nodeAtoms, Map<A, Boolean> leafAtoms) {
		if (nodeAtoms==null || leafAtoms==null) throw new IllegalArgumentException();
		for (int literalID : model) {
			String key = this.getNodeKeyForLiteralID(literalID);
			if (key != null  && !AndOrTree.isPseudoNode(key)) {
				Boolean value = literalID > 0 ? true : false;
				A atom = this.nodeKey2AtomMap.get(key);
				nodeAtoms.put(atom, value);
				if (this.independentVariables.contains(key)) {
					leafAtoms.put(atom, value);
				}
			}
		}
	}
	
	protected TreeMap<A, Boolean> getAtomValues(int[] model) {
		TreeMap<A, Boolean> nodeAtoms = new TreeMap<>();
		for (int literalID : model) {
			String key = this.getNodeKeyForLiteralID(literalID);
			if (key != null  && !AndOrTree.isPseudoNode(key)) {
				Boolean value = literalID > 0 ? true : false;
				A atom = this.nodeKey2AtomMap.get(key);
				nodeAtoms.put(atom, value);
			}
		}
		return nodeAtoms;
	}
	
	public ISATModel translateModel(int[] model) {
		Map<String, Boolean> nodeValues = new HashMap<>();
		Map<String, Boolean> leafValues = new HashMap<>();
		translateDIMACSModel(model, nodeValues, leafValues);
		return new SATModel(nodeValues, leafValues);
	}	
	
	// CNF Formula artifacts
	private A createOrGetAtom(String nodeKey) {
		if (nodeKey == null || nodeKey.trim().isEmpty() ) {
			throw new IllegalArgumentException("Goal node name is null! " +
					"Every node in the model must have a name!");
		}
		A atom = this.nodeKey2AtomMap.get(nodeKey);
		if (atom == null) {
			atom = this.compFactory.createAtom(nodeKey);
			nodeKey2AtomMap.put(nodeKey, atom);
		} 
		return atom;
	}

	private L createLiteralInstance(A atom, boolean isNegated) {
		L literal = this.compFactory.createLiteral(atom, isNegated);
//		if(isNegated) {
//			atom.addNegativeLiteral(literal);
//		} else {
//			atom.addPositiveLiteral(literal);
//		}
		return literal;
	}
	
	protected L createLiteral(String nodeKey, boolean isNegated) {
		A a = this.createOrGetAtom(nodeKey);
		L literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	protected C createClause() {
		return this.compFactory.createClause();
	}
	
	private String getNodeKeyForLiteralID(int id) {
		return this.atomID2NodeKeyMap.get(Math.abs(id));
	}
	
	private void addClause(C clause) {
		this.clauses.add(clause);
	}
	
	private void addAllClauses(ArrayList<C> clauses) {
		for (C c : clauses) {
			this.addClause(c);
		}
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		Iterator<C> iter = this.clauses.iterator();
		while (iter.hasNext()) {
			C clause = (C) iter.next();
			buffer.append(clause);
			if (iter.hasNext()) {
				buffer.append(" ^\n");
			}
		}
		return buffer.toString();
	}
	
	public void addAtomConstraint(String atomKey, boolean value) {
		C c = this.compFactory.createClause();
		L lit = this.createLiteral(atomKey, !value);
		c.addLiteral(lit);
		this.constraints.put(atomKey, c);
	}
	
	public void removeAtomConstraint(String atomKey) {
		this.constraints.remove(atomKey);
	}
}

