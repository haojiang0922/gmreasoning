package gr.ntua.softeng.wtt.sat.opt.cnf.gasat;

import org.opt4j.optimizers.ea.SelectorModule;

public class GasatSelectorModule extends SelectorModule {

	@Override
	protected void config() {
		this.bindSelector(GasatSelector.class);
	}

}
