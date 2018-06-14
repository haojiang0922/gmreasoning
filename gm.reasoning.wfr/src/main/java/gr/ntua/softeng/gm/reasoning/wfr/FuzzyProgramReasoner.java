package gr.ntua.softeng.gm.reasoning.wfr;

import java.util.Vector;

import cs.EvaluationParameters;
import cs.Program;
import gr.ntua.softeng.gm.reasoning.GoalModelReasoningException;
import gr.ntua.softeng.gm.reasoning.wfr.components.FuzzyLogicProgram;
import math.Interval;
import math.norms.ProbabilisticSNorm;
import math.norms.ProbabilisticTNorm;
import math.norms.ProbabilisticWeightedConjunction;
import math.norms.SNorm;
import math.norms.TNorm;
import math.norms.WeightedConjunction;
import wfd.Interpretation;
import wfd.Term;
import wfd.semantics.Definite;
import wfd.semantics.Semantics;


public class FuzzyProgramReasoner {

	private Program pg;
	private Semantics semantics;
	private Interpretation itp = null;
	
	
	public FuzzyProgramReasoner(FuzzyLogicProgram flProgram) {
		String programText = flProgram.getProgram();
		semantics = new Definite();
		//Create Program object
		pg = new Program(null, true, false, semantics, false, false);
		//Load actual program and parse 
		Vector errors = new Vector();
		boolean ok = pg.parse(programText, errors);
		if(!ok) {
			throw new GoalModelReasoningException("Program Initialization Error!", errors);
		}
	}
	
	public void performReasoning() {
		EvaluationParameters evParameters = getEvalParams();
		try {
			itp = pg.lfp(evParameters);
		} catch(Exception e) {
			e.printStackTrace();
			throw new GoalModelReasoningException(e.getMessage());
		}
	}
	
	public String executeQuery(String queryText) {
		try {
			//Parse query
			Term query = Term.parse(queryText);
			//Get answer to any term query;
			Interval interval = itp.getValue(query);
			return interval.toString();
		} catch(Exception e) {
			//e.printStackTrace();
			throw new GoalModelReasoningException("Unable to execute query \"" + queryText + "\"");
		}
	}
		
	private EvaluationParameters getEvalParams() {
		TNorm tnorm = new ProbabilisticTNorm(); // probabilistic product
		SNorm snorm = new ProbabilisticSNorm(); // probabilistic sum
		WeightedConjunction wc = new ProbabilisticWeightedConjunction();//new StandardWeightedConjunction(new ProbabilisticSNorm(), new ProbabilisticTNorm());
		
		double accuracy = 1E-10;
		EvaluationParameters evParameters = new EvaluationParameters(tnorm, snorm, wc, accuracy, semantics, false);
		return evParameters;
	}
	
	public Interpretation getInterpretation() {
		return itp;
	}
}
