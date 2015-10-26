package ia.facol.ga.mutation.impl;

import ia.facol.ga.genetic.Chromosome;
import ia.facol.ga.mutation.Mutation;
import ia.facol.problems.benchmark.Problemable;

public class UniformMutation extends Mutation {

	public void mutate(Chromosome gene, int position){
		Problemable problem = gene.getConfiguration().getProblem();
		Double newValue = 0.0;
		
		/*
		 * Gerar um número uniformemente distribuido baseado nos limites do problema.
		 */
		gene.getGeneticInformation().set(position, newValue);
	}
}
