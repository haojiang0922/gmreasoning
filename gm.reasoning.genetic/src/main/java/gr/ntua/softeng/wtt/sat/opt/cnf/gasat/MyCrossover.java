package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.core.common.random.Rand;
import org.opt4j.operators.crossover.CrossoverBooleanDefault;

import com.google.inject.Inject;

public class MyCrossover extends CrossoverBooleanDefault {

	@Inject
	public MyCrossover(Rand random) {
		super(random);
		System.out.println("Inside my crossover!");
	}

}
