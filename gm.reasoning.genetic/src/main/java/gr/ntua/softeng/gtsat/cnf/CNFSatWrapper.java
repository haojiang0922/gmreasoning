package gr.ntua.softeng.gtsat.cnf;

import gr.ntua.softeng.gtsat.SATModel;
import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;
import gr.ntua.softeng.gtsat.goalmodel.IGoalModelAbstraction;
import gr.ntua.softeng.gtsat.goalmodel.rules.CompositeRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.ConstraintRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalContributionRule;
import gr.ntua.softeng.gtsat.goalmodel.rules.GoalDecompositionRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class CNFSatWrapper {
	
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
	
	private static final String DECOMPOSITION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_d";
	private static final String CONTRIBUTION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_c";
	private static final String POS_CONTRIBUTION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_c_pos";
	private static final String NEG_CONTRIBUTION_PSEUDO_NODE_SUFFIX = IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED + "_c_neg";
	
	private Map<String,Atom> nodeKey2AtomMap = new HashMap<String, Atom>();
	private Map<Integer,String> atomID2NodeKeyMap = new HashMap<Integer, String>();
		
	private CNFFormula formula;
	
	public CNFSatWrapper(GoalModelAbstraction goalModel) {
		formula = new CNFFormula();
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
		for (AbstractClause c : this.formula.getClauses()) {
			for (Literal l : c.getLiterals()) {
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
	private void parseRules(Set<CompositeRule> rules) {
		for (CompositeRule r : rules) {
			this.updateFormula(r);
		}
	}
	
	private void updateFormula(CompositeRule rule) {
		boolean hasDecomposition = rule.hasDecomposition();
		boolean hasContributions = rule.hasContributions();
		if (hasDecomposition && !hasContributions) {
			GoalDecompositionRule decompRule = rule.getDecompositionRule();
			this.updateFormula(decompRule.getParentNodeKey(), decompRule.getChildNodeKeys(), decompRule.isANDDecomposed());
		} else if (hasDecomposition && hasContributions) {
			/*  O <- AND(i1,i2...,in) / O <- OR(i1,i2...,in)
			 *  if node O is the target node of one or more contributions then :
			 *  1. O <- OR(O_d,O_c)
			 *  2. O_d <- AND(i1,i2...,in) / O_d <- OR(i1,i2...,in) 
			 *  3. all contributions must now have as target O_c node
			 */ 
			String decomposedNode = rule.getGoalNodeKey();
			Literal decomposedNodeLiteral = this.createLiteral(rule.getGoalNodeKey(), false);
			// add clauses for a new OR-decomposition of the form O <- OR(O_d,O_c)
			Set<Literal> childNodeLiterals = new HashSet<Literal>();
			Literal contrPseudoLit = this.createContrPseudoLiteral(decomposedNode, false);
			childNodeLiterals.add(contrPseudoLit);
			Literal decompPseudoLit = this.createDecompPseudoLiteral(decomposedNode, false);
			childNodeLiterals.add(decompPseudoLit);
			Vector<Clause> clauses = this.getORGateClauses(decomposedNodeLiteral, childNodeLiterals);
			this.addAllClauses(clauses);
			// add clauses related to the initial AND/OR-decomposition
			// change the name of the decomposed goal from O to O_d
			GoalDecompositionRule decompRule = rule.getDecompositionRule();
			this.updateFormula(this.decompPseudoNodeKey(decomposedNode), decompRule.getChildNodeKeys(), decompRule.isANDDecomposed());
			// handle contribution rules
			updateFormulaWithContributions(rule, true);
		} else {
			// hasDecomposition = false && hasContributions = true 
			// this is a leaf node and also the target node of some contributions
			updateFormulaWithContributions(rule, false);
		}
	}
	
	private void updateFormulaWithContributions(CompositeRule rule, boolean createContrPseudoNode) {
		String key = rule.getGoalNodeKey();
		if (!rule.getPosContributionRules().isEmpty() && !rule.getNegContributionRules().isEmpty()) {
			if (createContrPseudoNode) {
				// a_c <- AND(a_c_pos, "NOT" a_c_neg)
				Literal contrPseudoLiteral = this.createContrPseudoLiteral(key, false);
				Set<Literal> posNegPseudoLit = new HashSet<Literal>();
				posNegPseudoLit.add(this.createPosContrPseudoLiteral(key, false));
				posNegPseudoLit.add(this.createNegContrPseudoLiteral(key, true));
				Vector<Clause> clauses = this.getANDGateClauses(contrPseudoLiteral, posNegPseudoLit);
				this.addAllClauses(clauses);
			} else {
				// a <- AND(a_c_pos, "NOT" a_c_neg)
				Literal contrLiteral = this.createLiteral(key, false);
				Set<Literal> posNegPseudoLit = new HashSet<Literal>();
				posNegPseudoLit.add(this.createPosContrPseudoLiteral(key, false));
				posNegPseudoLit.add(this.createNegContrPseudoLiteral(key, true));
				Vector<Clause> clauses = this.getANDGateClauses(contrLiteral, posNegPseudoLit);
				this.addAllClauses(clauses);
			}
			// a_c_pos <- OR(sources of all ++S/--D contributions)
			Literal contrPosLiteral = this.createPosContrPseudoLiteral(key, false);
			Set<Literal> sourceLiterals = new HashSet<Literal>();
			for (GoalContributionRule r : rule.getPosContributionRules()) {
				Literal lit = this.createLiteral(r.getSourceNodeKey(), r.isMMD());
				sourceLiterals.add(lit);
			}
			Vector<Clause> clauses = this.getORGateClauses(contrPosLiteral, sourceLiterals);
			this.addAllClauses(clauses);
			// a_c_neg <- OR(sources of all --S/++D contributions)
			Literal contrNegLiteral = this.createNegContrPseudoLiteral(key, false);
			sourceLiterals = new HashSet<Literal>();
			for (GoalContributionRule r : rule.getNegContributionRules()) {
				Literal lit = this.createLiteral(r.getSourceNodeKey(), r.isPPD());
				sourceLiterals.add(lit);
			}
			clauses = this.getORGateClauses(contrNegLiteral, sourceLiterals);
			this.addAllClauses(clauses);
		} else if (!rule.getPosContributionRules().isEmpty()){
			// a <- OR(sources of all --S/++D contributions)
			Literal contrLiteral = this.createLiteral(key, false);
			Set<Literal> sourceLiterals = new HashSet<Literal>();
			for (GoalContributionRule r : rule.getPosContributionRules()) {
				Literal lit = this.createLiteral(r.getSourceNodeKey(), r.isMMD());
				sourceLiterals.add(lit);
			}
			Vector<Clause> clauses = this.getORGateClauses(contrLiteral, sourceLiterals);
			this.addAllClauses(clauses);
		} else {
			// NOT a <- OR(sources of all --S/++D contributions)
			Literal contrNegLiteral = this.createLiteral(key, true);
			Set<Literal> sourceLiterals = new HashSet<Literal>();
			for (GoalContributionRule r : rule.getNegContributionRules()) {
				Literal lit = this.createLiteral(r.getSourceNodeKey(), r.isPPD());
				sourceLiterals.add(lit);
			}
			Vector<Clause> clauses = this.getORGateClauses(contrNegLiteral, sourceLiterals);
			this.addAllClauses(clauses);
		}
	}
	
	private void updateFormula(String parentNodeKey, Set<String> childKeys, boolean isANDDecomposed) {
		Vector<Clause> decompositionClauses = null;
		// Get decomposition details
		Literal parentNodeLiteral = this.createLiteral(parentNodeKey, false);
		Set<Literal> childNodeLiterals = new HashSet<Literal>();
		for (String c : childKeys) {
			Literal lit = this.createLiteral(c, false);
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
	private Vector<Clause> getANDGateClauses(Literal outputLiteral, Set<Literal> inputs) {
		Vector<Clause> allClauses = new Vector<Clause>();
			
		Clause clause = new Clause();		
		for (Literal i : inputs) {
			Literal inputLiteralNeg = i.getNegatedLiteral();
			// every literal should be a different object even if it corresponds to the same atom (or its negation)
			Literal outputLiteralNeg = outputLiteral.getNegatedLiteral();
			// term clause
			Clause termClause = new Clause();
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
	private Vector<Clause> getORGateClauses(Literal outputLiteral, Set<Literal> inputs) {
		Vector<Clause> allClauses = new Vector<Clause>();
		
		Clause clause = new Clause();		
		for (Literal i : inputs) {
			Literal inputLiteralNeg = i.getNegatedLiteral();
			// every literal should be a different object even if it corresponds to the same atom (or its negation)
			Literal outputLiteralClone = this.createLiteralInstance(outputLiteral);
			// term clause
			Clause termClause = new Clause();
			termClause.addLiteral(inputLiteralNeg);
			termClause.addLiteral(outputLiteralClone);
			allClauses.add(termClause);
			//
			clause.addLiteral(i);
		}
		
		Literal outputLiteralNeg = outputLiteral.getNegatedLiteral();
		
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
		CNFFormula f = this.createGoalNodeFormula(rule, !rule.getValue());
		this.formula.concatenateFormula(f);
	}
		
	private CNFFormula createGoalNodeFormula(ConstraintRule rule, boolean isNegated) {
		Clause c = new Clause();
		Literal lit = this.createLiteral(rule.getName(), isNegated);
		c.addLiteral(lit);
		return new CNFFormula(c);
	}
	
	//		
	public int getNumOfClauses() {
		return this.formula.size();
	}

	public List<int[]> getClausesInDIMACS() {
		List<int[]> clausesInDIMACS = new ArrayList<int[]>(this.getNumOfClauses());
		for (AbstractClause c : this.formula.getClauses()) {
			int[] clause = c.getDIMACSFormat();
			clausesInDIMACS.add(clause);
		}
		return clausesInDIMACS;
	}

	//TODO remove this method if possible
	public Vector<AbstractClause> getClauses() {
		return this.formula.getClauses();
	}
	
	public int getNumOfAtoms() {
		return this.nodeKey2AtomMap.size();
	}
	
	protected Map<String, Boolean> translateDIMACSModel(int[] model) {
		Map<String, Boolean> nodeValues = new HashMap<String, Boolean>();
		for (int literalID : model) {
			String key = this.getNodeKeyForLiteralID(literalID);
			if (key != null 
					&& !key.contains(IGoalModelAbstraction.PSEUDO_NODE_IDENTIFIED)
			) {
				nodeValues.put(key, literalID > 0 ? true : false);
			}
		}
		return nodeValues;
	}
	
	public SATModel translateModel(int[] model) {
		Map<String, Boolean> nodeValues = translateDIMACSModel(model);
		return new SATModel(nodeValues);
	}	
	
	// CNF Formula artifacts
	private Atom createOrGetAtom(String nodeKey) {
		if (nodeKey == null || nodeKey.trim().isEmpty() ) {
			throw new IllegalArgumentException("Goal node name is null! " +
					"Every node in the model must have a name!");
		}
		Atom atom = nodeKey2AtomMap.get(nodeKey);
		if (atom == null) {
			atom = new Atom(nodeKey);
			nodeKey2AtomMap.put(nodeKey, atom);
		} 
		return atom;
	}
	
	protected Literal createLiteralInstance(Atom atom, boolean isNegated) {
		Literal literal = new Literal(atom, isNegated);
//		if(isNegated) {
//			atom.addNegativeLiteral(literal);
//		} else {
//			atom.addPositiveLiteral(literal);
//		}
		return literal;
	}
	
	private Literal createLiteralInstance(Literal lit) {
		Literal literal = this.createLiteralInstance(lit.getAtom(), lit.isNegated());
		return literal;
	}
	
	protected Literal createLiteral(String nodeKey, boolean isNegated) {
		Atom a = this.createOrGetAtom(nodeKey);
		Literal literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	private Literal createContrPseudoLiteral(String nodeKey, boolean isNegated) {
		String key = nodeKey + CONTRIBUTION_PSEUDO_NODE_SUFFIX;
		Atom a = this.createOrGetAtom(key);
		Literal literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	private Literal createPosContrPseudoLiteral(String nodeKey, boolean isNegated) {
		String key = nodeKey + POS_CONTRIBUTION_PSEUDO_NODE_SUFFIX;
		Atom a = this.createOrGetAtom(key);
		Literal literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	private Literal createNegContrPseudoLiteral(String nodeKey, boolean isNegated) {
		String key = nodeKey + NEG_CONTRIBUTION_PSEUDO_NODE_SUFFIX;
		Atom a = this.createOrGetAtom(key);
		Literal literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	private Literal createDecompPseudoLiteral(String nodeKey, boolean isNegated) {
		String key = nodeKey + DECOMPOSITION_PSEUDO_NODE_SUFFIX;
		Atom a = this.createOrGetAtom(key);
		Literal literal = createLiteralInstance(a, isNegated);
		return literal;
	}
	
	private String decompPseudoNodeKey(String nodeKey) {
		return nodeKey + DECOMPOSITION_PSEUDO_NODE_SUFFIX;
	}
	
	private String getNodeKeyForLiteralID(int id) {
		return this.atomID2NodeKeyMap.get(Math.abs(id));
	}
	
	protected void addClause(AbstractClause clause) {
		this.formula.addClause(clause);
	}
	
	private void addAllClauses(Vector<Clause> clauses) {
		for (Clause c : clauses) {
			this.addClause(c);
		}
	}
	
	public String toString() {
		return this.formula.toString();
	}
	
	protected Atom getAtomFromNodeKey(String nodeKey) {
		return this.nodeKey2AtomMap.get(nodeKey);
	}
	
	protected String getNodeKeyFromAtomId(Integer id) {
		return this.atomID2NodeKeyMap.get(id);
	}
	
	public CNFFormula getCNFFormula() {
		return this.formula;
	}
}

