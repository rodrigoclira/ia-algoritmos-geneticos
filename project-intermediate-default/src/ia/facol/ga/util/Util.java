package ia.facol.ga.util;

import ia.facol.ga.genetic.Chromosome;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Util {
	
	public static Random random = new Random();
	
	public static List<Chromosome> rouleteWheel(List<Chromosome> genes, int numberIndividuos){
		List<Chromosome> individuos = new LinkedList<Chromosome>();
		Chromosome gene = null;
		while (individuos.size() < numberIndividuos){
			gene = roulete(genes);
			individuos.add(gene);
		}
		return individuos;
	}
	
		
	private static Chromosome roulete(List<Chromosome> genes ){
		int count = 0;
		double sumFitness = 0.0;
		
		for (Chromosome g : genes){
			sumFitness += g.getFitness();
		}
		
		double fitnessReached = 0;
		double sortedValue = random.nextDouble()  * (sumFitness - 0) + 0; 
		
		while(count < genes.size()){
			fitnessReached += genes.get(count).getFitness();
			count+=1;
			if (fitnessReached >= sortedValue){
				break;
			}
		}
		Chromosome geneChosen = genes.get(count - 1);
		genes.remove(count - 1);
		return geneChosen;
	}
	
		
	public static void limitPosition(Chromosome gene, int position){
		Double value = (Double) gene.getGeneticInformation().get(position);
		Double upperBound = gene.getConfiguration().getProblem().getUpperBound();
		Double lowerBound = gene.getConfiguration().getProblem().getLowerBound();
		
	    /*
	     * TODO
	     * Limitar as posições dos genes para não alcançarem posições fora do espaço de busca.
	     */
	}
	

}
