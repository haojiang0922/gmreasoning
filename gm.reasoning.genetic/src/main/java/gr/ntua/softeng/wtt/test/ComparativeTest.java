package gr.ntua.softeng.wtt.test;

public class ComparativeTest {

	public static void main(String[] args) {
		
		String[] maxSatArgs = { "test_costs.wtt"};
		SolverTest.main(maxSatArgs);
		System.gc();
		SolverTest.main(maxSatArgs);
		
		for (int i = 1000; i <= 5000; i=i+500) {
			String[] intervalsTestArgs = { "test_costs.wtt", i+"" };
			WebTaskTemplateSATTest.main(intervalsTestArgs);
			System.gc();
		}
		
		OptimizationTest.main(maxSatArgs);
	}

}
