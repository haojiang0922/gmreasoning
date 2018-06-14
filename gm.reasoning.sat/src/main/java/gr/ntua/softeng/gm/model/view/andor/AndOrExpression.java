package gr.ntua.softeng.gm.model.view.andor;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;

public class AndOrExpression {

	private Expression expression = null;
	private String var = null;
	
	public AndOrExpression(Expression expression, String var) {
		this.expression = expression;
		this.var = var;
	}

	public Boolean evaluate(JexlContext jexlContext) {
		Boolean res = (Boolean)this.expression.evaluate(jexlContext);
		jexlContext.set(var, res);
		return res;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public String getVar() {
		return this.var;
	}
}
