package ia.facol.ga.crossover.tsp;

import java.util.LinkedList;

import ia.facol.ga.genetic.tsp.GATSP;
import ia.facol.ga.genetic.tsp.ChromosomeTSP;

public class CrossOverTwoPointsTSP{

	public LinkedList<ChromosomeTSP> crossover(ChromosomeTSP geneA, ChromosomeTSP geneB) {
		int crossoverPoint1 = geneA.choosePosition();
		int crossoverPoint2 = 0;
		
		ChromosomeTSP child1 = new ChromosomeTSP(GATSP.COUNTER, geneA.getConfiguration());
		ChromosomeTSP child2 = new ChromosomeTSP(GATSP.COUNTER + 1, geneA.getConfiguration());
		child1.generateNullIndividual();
		child2.generateNullIndividual();
		GATSP.COUNTER += 2;
		
		do{
			crossoverPoint2 = geneA.choosePosition();
			
			if (crossoverPoint1 > crossoverPoint2){
				int temp = crossoverPoint1;
				crossoverPoint1 = crossoverPoint2;
				crossoverPoint2 = temp;
			}
			
		}while(crossoverPoint1 == crossoverPoint2);
		
		int count = 0;

		/*
		 * @TODO Implementar o crossover de dois pontos.
		 * 
		 */
		
		
		fillChild(child1, geneA);
		fillChild(child2, geneB);
		child1.setModified(true);
		child2.setModified(true);
		
		LinkedList<ChromosomeTSP> children = new LinkedList<ChromosomeTSP>();
		
		children.add(child1);
		children.add(child2);
		
		if (GATSP.DEBUG){
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
	
	
	private void fillChild(ChromosomeTSP child, ChromosomeTSP parent){

		for (int i = 0; i < parent.getGeneticInformation().size(); i++) {
            // Se o filho não possui a cidade, adiciona ela
            if (!child.containsCity(parent.getCity(i))) {
                // Loop para encontrar um lugar nulo e adicionar
                for (int ii = 0; ii < child.getGeneticInformation().size(); ii++) {
                    // Lugar nulo encontra, adicione a cidade.
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent.getCity(i));
                        break;
                    }
                }
            }
        }
		
		
	}
}
