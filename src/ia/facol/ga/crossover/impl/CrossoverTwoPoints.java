package ia.facol.ga.crossover.impl;

import ia.facol.ga.crossover.Crossover;
import ia.facol.ga.genetic.GA;
import ia.facol.ga.genetic.Gene;

import java.util.LinkedList;

public class CrossoverTwoPoints extends Crossover {

	@Override
	public LinkedList<Gene> crossover(Gene geneA, Gene geneB) {
		int crossoverPoint1 = geneA.choosePosition();
		int crossoverPoint2 = 0;
		
		do{
			crossoverPoint2 = geneA.choosePosition();
			
			if (crossoverPoint1 > crossoverPoint2){
				int temp = crossoverPoint1;
				crossoverPoint1 = crossoverPoint2;
				crossoverPoint2 = temp;
			}
			
		}while(crossoverPoint1 == crossoverPoint2);
		
		int count = 0;
		
		LinkedList<Double> geneticInfoChild1 = new LinkedList<Double>();
		LinkedList<Double> geneticInfoChild2 = new LinkedList<Double>();
		
		while (count < geneA.getGeneticInformation().size()){
			if (count >= crossoverPoint1 && count <= crossoverPoint2){
				geneticInfoChild1.add(geneB.getGeneticInformation().get(count));
				geneticInfoChild2.add(geneA.getGeneticInformation().get(count));
			}else{
				geneticInfoChild1.add(geneA.getGeneticInformation().get(count));
				geneticInfoChild2.add(geneB.getGeneticInformation().get(count));				
			}
			count+=1;
		}
				
		LinkedList<Gene> children = new LinkedList<Gene>();
		Gene child1 = new Gene(GA.COUNTER, geneA.getConfiguration(), geneticInfoChild1);
		Gene child2 = new Gene(GA.COUNTER + 1, geneA.getConfiguration(), geneticInfoChild2); 
		GA.COUNTER += 2;
		children.add(child1);
		children.add(child2);
		
		if (GA.DEBUG){
			System.out.println("Crossover two point | P1=" + crossoverPoint1 + " P2=" + crossoverPoint2);
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
