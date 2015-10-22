package ia.facol.ga.crossover.impl.tsp;

import java.util.LinkedList;

import ia.facol.ga.genetic.GA;
import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.problems.tsp.City;

public class CrossOverTwoPointsTSP{

	public LinkedList<GeneTSP> crossover(GeneTSP geneA, GeneTSP geneB) {
		int crossoverPoint1 = geneA.choosePosition();
		int crossoverPoint2 = 0;
		
		GeneTSP child1 = new GeneTSP(GA.COUNTER, geneA.getConfiguration());
		GeneTSP child2 = new GeneTSP(GA.COUNTER + 1, geneA.getConfiguration());
		child1.generateNullIndividual();
		child2.generateNullIndividual();
		GA.COUNTER += 2;
		
		do{
			crossoverPoint2 = geneA.choosePosition();
			
			if (crossoverPoint1 > crossoverPoint2){
				int temp = crossoverPoint1;
				crossoverPoint1 = crossoverPoint2;
				crossoverPoint2 = temp;
			}
			
		}while(crossoverPoint1 == crossoverPoint2);
		
		int count = 0;
		
		while (count < geneA.getGeneticInformation().size()){
			if (count >= crossoverPoint1 && count <= crossoverPoint2){
				child1.getGeneticInformation().set(count, geneB.getGeneticInformation().get(count));				
				child2.getGeneticInformation().set(count, geneA.getGeneticInformation().get(count));
			}
			count+=1;
		}
		
		fillChild(child1, geneA);
		fillChild(child2, geneB);
		child1.setModified(true);
		child2.setModified(true);
		
		LinkedList<GeneTSP> children = new LinkedList<GeneTSP>();
		
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
	
	
	private void fillChild(GeneTSP child, GeneTSP parent){

		for (int i = 0; i < parent.getGeneticInformation().size(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(parent.getCity(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.getGeneticInformation().size(); ii++) {
                    // Spare position found, add city
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent.getCity(i));
                        break;
                    }
                }
            }
        }
		
		
	}
}
