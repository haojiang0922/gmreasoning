package gr.ntua.softeng.gm.model.view.andor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

public class AndOrGraphEvaluator implements Evaluator {

	private JexlEngine jexl = new JexlEngine();
	private JexlContext jexlContext = new MapContext();
	private LinkedList<AndOrExpression> expressionList = new LinkedList<>();
	private Expression finalExpression = null;
	private String rootVar = null;
	
	public AndOrGraphEvaluator(AndOrGraph graph) {
		this.jexl.setSilent(true);
		this.jexl.setLenient(true);
		List<AndOrRule> rules = graph.getSortedRulesList();
		for (AndOrRule r : rules) {
			AndOrExpression expression = this.createExpression(r);
			expressionList.add(expression);
		}
		AndOrExpression e = expressionList.removeLast();
		finalExpression = e.getExpression();
		rootVar = e.getVar();
		//Initial Evaluation
		this.evaluate(new HashMap<String,Boolean>(), new HashSet<String>());
	}

	@Override
	public boolean evaluate(Map<String,Boolean> values, Set<String> trueNodes) {
		if (trueNodes == null) throw new IllegalArgumentException();
		Set<String> newValueKeys = values.keySet();
		//Update Context
		for (Entry<String,Boolean> v : values.entrySet()) {
			this.jexlContext.set(v.getKey(), v.getValue());
			if (v.getValue()) trueNodes.add(v.getKey());
		}
		//Evaluate
		for (AndOrExpression e : this.expressionList) {
			if (!newValueKeys.contains(e.getVar())) {
				boolean v = e.evaluate(this.jexlContext);
				if (v) trueNodes.add(e.getVar());
			}
		}
		Boolean rootRes = (Boolean) finalExpression.evaluate(this.jexlContext);
		if (rootRes) trueNodes.add(this.rootVar);
		return rootRes;
	}
	
	private AndOrExpression createExpression(AndOrRule r) {
		Expression e = jexl.createExpression(r.getJexlExpression());
		return new AndOrExpression(e, r.getParentNodeKey());
	}
}
