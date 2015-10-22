package ia.facol.ga.util;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.genetic.tsp.GeneTSP;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Util {
	
	public static Random random = new Random();
	
	public static List<Gene> rouleteWheel(List<Gene> genes, int numberIndividuos){
		List<Gene> individuos = new LinkedList<Gene>();
		Gene gene = null;
		while (individuos.size() < numberIndividuos){
			gene = roulete(genes);
			individuos.add(gene);
		}
		return individuos;
	}
	
	public static List<GeneTSP> rouleteWheelTSP(List<GeneTSP> genes, int numberIndividuos){
		List<GeneTSP> individuos = new LinkedList<GeneTSP>();
		GeneTSP gene = null;
		while (individuos.size() < numberIndividuos){
			gene = roulete(genes);
			individuos.add(gene);
		}
		return individuos;
	}
	
	private static Gene roulete(List<Gene> genes ){
		int count = 0;
		double sumFitness = 0.0;
		
		for (Gene g : genes){
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
		Gene geneChosen = genes.get(count - 1);
		genes.remove(count - 1);
		return geneChosen;
	}
	
	private static GeneTSP roulete(List<GeneTSP> genes){
		int count = 0;
		double sumFitness = 0.0;
		
		for (GeneTSP g : genes){
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
		
		GeneTSP geneChosen = genes.get(count - 1);
		genes.remove(count - 1);
		return geneChosen;
	}
	
	public static void limitPosition(Gene gene, int position){
		Double value = (Double) gene.getGeneticInformation().get(position);
		Double upperBound = gene.getConfiguration().getProblem().getUpperBound();
		Double lowerBound = gene.getConfiguration().getProblem().getLowerBound();
		
        if (value > upperBound){
            gene.getGeneticInformation().set(position, upperBound);
        }else if (value < lowerBound){
        	gene.getGeneticInformation().set(position, lowerBound);  
        }
	}
	

}
