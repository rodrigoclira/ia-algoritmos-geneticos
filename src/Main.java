
import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.configuration.ConfigurationBuilder;
import ia.facol.ga.crossover.impl.CrossoverOnePoint;
import ia.facol.ga.crossover.impl.CrossoverTwoPoints;
import ia.facol.ga.genetic.GA;
import ia.facol.ga.mutation.impl.GaussianMutation;
import ia.facol.ga.mutation.impl.UniformMutation;
import ia.facol.ga.selection.individuos.impl.ElitismSelection;
import ia.facol.ga.selection.parents.impl.RandomParentSelection;
import ia.facol.ga.selection.parents.impl.TournmentParentSelection;
import ia.facol.problems.benchmark.Esphere;
import ia.facol.problems.benchmark.Griewank;
import ia.facol.problems.benchmark.Rosembrock;



public class Main {

	public static void main(String[] args) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();		
		Configuration c = 
				cb.buildCrossoverQuantity(10)
				.buildCrossoverRate(0.9)
				.buildCrossoverType(new CrossoverTwoPoints())
				.buildMutationType(new GaussianMutation())			
				.buildIndividuosQuantity(30)
				.buildMutationRate(0.1)
				.buildProblemable(new Esphere(30, -5.2, 5.2))
				//.buildProblemable(new Griewank(30, -100, 100))
				//.buildProblemable(new Griewank(30, 600, -600))
				.buildIndSelection(new ElitismSelection())
				.buildParentSelection(new TournmentParentSelection())
				.getConfiguration();
		
		GA ga = new GA(c);
		ga.DEBUG = false;
		ga.run(10000);
		System.out.println(ga);

	}

}
