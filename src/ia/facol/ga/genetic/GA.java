package ia.facol.ga.genetic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ia.facol.ga.configuration.Configuration;

/**
 * 
 * @author Rodrigo Lira
 *
 */

public class GA {
	public static int COUNTER = 0;
	public static boolean DEBUG = false;
	private Configuration configuration;
	private List<Gene> individuos;
	private Random random;
	
	public GA(Configuration c){
		this.configuration = c;
		int count = 0;
		this.random = new Random();
		double value = 0.0;
		individuos = new LinkedList<Gene>();
		
		while (count < configuration.getIndividiuosQuantity()){
			LinkedList<Double> geneticInfo = new LinkedList<Double>();
			for (int i = 0; i < configuration.getProblem().getDimensions(); i+=1){
				value = random.nextDouble() * 
						(configuration.getProblem().getUpperBound() - configuration.getProblem().getLowerBound()) 
						+ configuration.getProblem().getLowerBound(); 
				geneticInfo.add(value);
			}
			
			Gene g = new Gene(GA.COUNTER, c, geneticInfo);
			individuos.add(g);
			
			count += 1;
			GA.COUNTER += 1;
		}
	}

	public void sort(boolean reverse){
		Collections.sort(individuos);
		if (!reverse){
			Collections.reverse(individuos);
		}
	}
	
	public void run(int iteration){
		int count = 0;
		//evalueteFitness();
		while (count < iteration){
			this.crossover();
			this.mutation();
			this.selectNewPopulation();
			count+=1;
		}
		
	}

	private void selectNewPopulation() {
		sort();
		this.individuos = configuration.getIndSelection().select(this.getIndividuos(), configuration);
		sort();
	}

	private void crossover(){
		int count = 0;
		List<Gene> children = new LinkedList<Gene>();
		List<Gene> tempChild = null;
		while (count < configuration.getCrossoverQuantity()){
			Gene father = configuration.getParSelection().select(this.individuos);
			Gene mother = configuration.getParSelection().select(this.individuos, father);
			tempChild = configuration.getCrossoverType().crossover(father, mother);
			children.addAll(tempChild);
			count +=1;
		}
		this.individuos.addAll(children);
	}
	
	
	public void sort(){
		//sort(false);
		sort(true);
	}
	
	private void mutation(){
		for (Gene g : individuos){
			g.mutation();
		}
	}
	
	
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public List<Gene> getIndividuos() {
		return individuos;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder(); 
		result.append(configuration.toString() + "\n");
		for (Gene g : individuos){
			result.append(g);
		}
		return result.toString();
	}
}
