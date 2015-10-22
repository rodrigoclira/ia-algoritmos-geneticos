package ia.facol.problems.benchmark;

import java.util.List;

public class Rosembrock extends Problemable{
	
	public static final String NAME = "Rosembrock";
	
	public Rosembrock(int dimensions, double lowerBound, double upperBound){
		super(NAME, dimensions,  lowerBound, upperBound);
	}
	
	/**
	 * http://www-optima.amp.i.kyoto-u.ac.jp/member/student/hedar/Hedar_files/TestGO_files/Page2537.htm
	 */
	@Override
	public Double evaluate(List<Double> gene) {
		double sum = 0;
		int count = 0;
		double xi1, xi;
		
		/* TODO
		 * Implementar Rosebrock
		 */
		
		return sum;
	}

}
