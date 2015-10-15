package ia.facol.ga.mutation.impl;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.mutation.Mutation;
import ia.facol.problems.benchmark.Problemable;

public class UniformMutation extends Mutation {

	public void mutate(Gene gene, int position){
		Problemable problem = gene.getConfiguration().getProblem();
		
		double newValue = getRandom().nextDouble() * 
				(problem.getUpperBound() - problem.getLowerBound()) 
				+ problem.getLowerBound();
		
		gene.getGeneticInformation().set(position, newValue);
	}
}
