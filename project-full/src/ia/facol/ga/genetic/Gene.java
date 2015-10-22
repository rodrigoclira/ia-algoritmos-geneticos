package ia.facol.ga.genetic;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.util.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Gene implements Comparable<Gene>{
	private boolean modified;
	private List<Double> geneticInformation;
	private Random random;
	private double fitness;
	private Configuration configuration;
	private int id;
	
	public Gene(int identifier, Configuration configuration, List<Double> geneticInformation){
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
			double prevFitness = getFitness();

			double prevValue = geneticInformation.get(position);

			configuration.getMutation().mutate(this, position);
			
			double newValue = geneticInformation.get(position);

			geneticInformation.set(position, newValue);
			setModified(true);

			double newFitness = getFitness();

			if (newFitness > prevFitness){
				geneticInformation.set(position, prevValue);
				setModified(true);
			}
			
			Util.limitPosition(this, position);
		}
			
	}
	
	public List<Gene> crossover(Gene gene){
		List <Gene> children = new LinkedList<Gene>();
		
		if (random.nextDouble() <= configuration.getCrossoverRate()){
			//this.setModified(true);
			children = this.configuration.getCrossoverType().crossover(this, gene);
			
		}
		
		return children;
	}
	
	private String  printIndividuos(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (Double g : this.geneticInformation){
			sb.append(" " + g);
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public String toString(){
		String st = null;
		
		
		st = String.format("(%05d) | Mod = %b | FIT = %05.25f | INFO = %s\n", this.id, this.isModified(), this.getFitness(), printIndividuos());
		
		return st;
	}

	@Override
	public int compareTo(Gene o) {
		int comp = 0;
		if (this.getFitness() < o.getFitness()){
			comp =  -1;
		}else if (this.getFitness() > o.getFitness()){
			comp = 1;
		}
		return comp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
