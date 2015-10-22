package ia.facol.ga.genetic.tsp;

import ia.facol.ga.configuration.tsp.ConfigurationTSP;
import ia.facol.problems.tsp.City;
import ia.facol.problems.tsp.TourManager;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeneTSP implements Comparable<GeneTSP> {
	/*
	 * http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
	 */
	
	private boolean modified;
	private List<City> geneticInformation;
	private Random random;
	private double fitness;
	private ConfigurationTSP configuration;
	private int id;
	private int distance = 0;
	
	
	public GeneTSP(int identifier, ConfigurationTSP configuration){
		this(identifier, configuration, new LinkedList<City>());
	}
	
	public GeneTSP(int identifier, ConfigurationTSP configuration, List<City> geneticInformation){
		random = new Random();
		this.id = identifier;
		this.configuration = configuration;
		this.geneticInformation = geneticInformation;
		this.modified = true;
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

	public List<City> getGeneticInformation() {
		return geneticInformation;
	}

	public void setGeneticInformation(List<City> geneticInformation) {
		this.geneticInformation = geneticInformation;
	}

	public ConfigurationTSP getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ConfigurationTSP configuration) {
		this.configuration = configuration;
	}
	
	public void mutation(){
		
		if (random.nextDouble() <= configuration.getMutationRate()){
			int position = choosePosition();
			//double prevFitness = getFitness();

			//City prevValue = geneticInformation.get(position);

			configuration.getMutation().mutate(this, position);
			setModified(true);
			//City newValue = geneticInformation.get(position);

			//geneticInformation.set(position, newValue);
			
			/*
			double newFitness = getFitness();

			if (newFitness > prevFitness){
				geneticInformation.set(position, prevValue);
				setModified(true);
			}
			*/
			//Util.limitPosition(this, position);
		}
			
	}	
	
	public List<GeneTSP> crossover(GeneTSP gene){
		List <GeneTSP> children = new LinkedList<GeneTSP>();
		
		if (random.nextDouble() <= configuration.getCrossoverRate()){
			//this.setModified(true);
			children = this.configuration.getCrossoverType().crossover(this, gene);
			
		}
		
		return children;
	}
	
	private String  printIndividuos(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		for (City g : this.geneticInformation){
			sb.append(g + " ; ");
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	
	public String toString(){
		String st = null;
		
		st = String.format("(%05d) | FIT = %05.3f | INFO = %s\n", this.id, this.getFitness(), printIndividuos());
		
		return st;
	}

	@Override
	public int compareTo(GeneTSP o) {
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
	
	/*
	 * New methods
	 */
	
	public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          addCity(TourManager.getCity(cityIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(geneticInformation);
        
    	setModified(true);
    }
	
	
	public void generateNullIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          this.geneticInformation.add(null);
        }

	}
	
	// Gets a city from the tour
    public City getCity(int tourPosition) {
        return (City)geneticInformation.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, City city) {
    	geneticInformation.set(tourPosition, city);
    	
    }
    
    public void addCity(City city) {
    	geneticInformation.add(city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    public boolean containsCity(City city){
        return geneticInformation.contains(city);
    }
	
}
