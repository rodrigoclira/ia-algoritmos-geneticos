package ia.facol.ga.mutation.impl;

import ia.facol.ga.genetic.Chromosome;
import ia.facol.ga.mutation.Mutation;
import ia.facol.problems.benchmark.Problemable;

public class GaussianMutation extends Mutation{

	@Override
	public void mutate(Chromosome gene, int position) {
		Problemable problem = gene.getConfiguration().getProblem();	
		//return getRandom().nextGaussian()  * prevValue + (problem.getUpperBound() - problem.getLowerBound();
		//http://stackoverflow.com/questions/6275827/how-to-implement-the-gaussian-mutation-operator-for-a-genetic-algorithm-in-java
		double prevValue = gene.getGeneticInformation().get(position);
		double newValue = prevValue + (getRandom().nextGaussian() * ((problem.getUpperBound() - problem.getLowerBound()) * 0.2) + 0);
		
		gene.getGeneticInformation().set(position, newValue);
	}

}
