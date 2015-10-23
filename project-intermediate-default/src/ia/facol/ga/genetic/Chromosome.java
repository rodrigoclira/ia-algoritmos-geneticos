package ia.facol.ga.genetic;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.ga.util.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Chromosome implements Comparable<Chromosome>{
	private boolean modified;
	private List<Double> geneticInformation;
	private Random random;
	private double fitness;
	private Configuration configuration;
	private int id;
	
	public Chromosome(int identifier, Configuration configuration, List<Double> geneticInformation){
		random = new Random();
		this.id = identifier;
		this.configuration = configuration;
		this.geneticInformation = geneticInformation;
		this.setModified(true);		
	}
	
	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
		if (modified){
			this.getFitness();
		}
	}
	
	public int choosePosition(){
		return random.nextInt(geneticInformation.size());
	}

	public double getFitness() {
		if (isModified()){
			this.fitness = configuration.getProblem().evaluate(getGeneticInformation());
			setModified(false);
		}
		
		return this.fitness;
	}

	public List<Double> getGeneticInformation() {
		return geneticInformation;
	}

	public void setGeneticInformation(List<Double> geneticInformation) {
		this.geneticInformation = geneticInformation;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	
	public void mutation(){
		
		if (random.nextDouble() <= configuration.getMutationRate()){
			int position = choosePosition();
			double prevFitness = 0;
			Double prevValue = 0d;
			
			/*
			 * TODO
			 * Aplicar o mutação na posição escolhida
			 */

			double newFitness = getFitness();

			if (newFitness > prevFitness){
				geneticInformation.set(position, prevValue);
				setModified(true);
			}
			
			Util.limitPosition(this, position);
		}
			
	}
	
	public List<Chromosome> crossover(Chromosome gene){
		List <Chromosome> children = new LinkedList<Chromosome>();
		
		/*
		 * TODO
		 * Aplicar o crossover de acordo com a taxa definida
		 */		
		
		return children;
	}
	
	/*
	 * TODO Implementar um método para impressão das informações do gene
	 */
	public String toString(){
		return "";
	}
	
	/*
	 * TODO Implementar uma forma de comparação do Gene.
	 */	
	@Override
	public int compareTo(Chromosome o) {
		return 0;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
