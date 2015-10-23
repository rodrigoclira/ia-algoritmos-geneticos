package ia.facol.ga.genetic.tsp;

import ia.facol.ga.configuration.tsp.ConfigurationTSP;
import ia.facol.problems.tsp.City;
import ia.facol.problems.tsp.TourManager;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChromosomeTSP implements Comparable<ChromosomeTSP> {
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
	
	
	public ChromosomeTSP(int identifier, ConfigurationTSP configuration){
		this(identifier, configuration, new LinkedList<City>());
	}
	
	public ChromosomeTSP(int identifier, ConfigurationTSP configuration, List<City> geneticInformation){
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
		/*
		 * TODO
		 * Aplicar a mutação de acordo com a taxa definida
		 */			
	}	
	
	public List<ChromosomeTSP> crossover(ChromosomeTSP gene){
		List <ChromosomeTSP> children = new LinkedList<ChromosomeTSP>();		
		/*
		 * TODO
		 * Aplicar a crossover de acordo com a taxa definida
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
	public int compareTo(ChromosomeTSP o) {
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	/*
	 *  TODO Implementar um método que pove o individuo automaticamente.  
	 */
	public void generateIndividual() {
        // 
        
    	setModified(true);
    }
	
	
	public void generateNullIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          this.geneticInformation.add(null);
        }

	}
	
	// Pegar uma cidade de um posição
    public City getCity(int tourPosition) {
        return (City)geneticInformation.get(tourPosition);
    }

    // Setar a cidade em uma posição
    public void setCity(int tourPosition, City city) {
    	geneticInformation.set(tourPosition, city);
    	
    }
    
    public void addCity(City city) {
    	geneticInformation.add(city);

        fitness = 0;
        distance = 0;
    }
    
    public boolean containsCity(City city){
        return geneticInformation.contains(city);
    }
	
}
