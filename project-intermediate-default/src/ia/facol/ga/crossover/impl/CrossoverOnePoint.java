package ia.facol.ga.crossover.impl;

import ia.facol.ga.crossover.Crossover;
import ia.facol.ga.genetic.GA;
import ia.facol.ga.genetic.Chromosome;

import java.util.LinkedList;

public class CrossoverOnePoint extends Crossover{
	
	@Override
	public LinkedList<Chromosome> crossover(Chromosome geneA, Chromosome geneB) {
		int crossoverPoint = geneA.choosePosition();
		int count = 0;
		
		LinkedList<Double> geneticInfoChild1 = new LinkedList<Double>();
		LinkedList<Double> geneticInfoChild2 = new LinkedList<Double>();
		
		/*
		 * TODO 
		 * Implementar o Crossover de um ponto
		 */
				
		LinkedList<Chromosome> children = new LinkedList<Chromosome>();
		Chromosome child1 = new Chromosome(GA.COUNTER, geneA.getConfiguration(), geneticInfoChild1);
		Chromosome child2 = new Chromosome(GA.COUNTER + 1, geneA.getConfiguration(), geneticInfoChild2); 
		GA.COUNTER += 2;
		children.add(child1);
		children.add(child2);
		
		if (GA.DEBUG){
			System.out.println("Crossover one point | point=" + crossoverPoint);
			System.out.println("Parents: ");
			System.out.print(geneA);
			System.out.print(geneB);
			System.out.println("Children: ");
			System.out.print(child1);
			System.out.print(child2);
		}
		
		return children;

	}
	
	

}
