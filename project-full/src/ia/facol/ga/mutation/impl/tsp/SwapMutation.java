package ia.facol.ga.mutation.impl.tsp;

import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.problems.tsp.City;

public class SwapMutation{

	public void mutate(GeneTSP gene, int position) {
		
		double prevFitness = gene.getFitness();
		int secondPosition = 0;
		City city1 = gene.getCity(position);
		City city2 = null;
		
		do{
			secondPosition = gene.choosePosition();
			city2 = gene.getCity(secondPosition);
		}while (city1.isTheSame(city2));
		
		gene.setCity(position, city2);
		gene.setCity(secondPosition, city1);
		/*
		gene.setModified(true);
		
		double newFitness = gene.getFitness();
		
		if (newFitness > prevFitness){
			gene.getGeneticInformation().set(position, city1);
			gene.getGeneticInformation().set(secondPosition, city2);
		}
		*/
	}

}
