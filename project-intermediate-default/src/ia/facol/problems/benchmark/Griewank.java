package ia.facol.problems.benchmark;

import java.util.List;

public class Griewank extends Problemable {
	
	public static final String NAME = "Griewank";
	
	public Griewank(int dimensions, double lowerBound, double upperBound){
		super(NAME, dimensions,  lowerBound, upperBound);
	}
	
	/**
	 * http://www-optima.amp.i.kyoto-u.ac.jp/member/student/hedar/Hedar_files/TestGO_files/Page1905.htm
	 */
	@Override
	public Double evaluate(List<Double> gene) {
		double sum = 0;
		double product = 1;
		int count = 0;
		
		/* TODO
		 * Impelmentar Griewank
		 */
		
		return sum + product + 1;
		
	}

}
