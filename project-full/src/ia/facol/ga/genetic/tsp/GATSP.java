package ia.facol.ga.genetic.tsp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import ia.facol.ga.configuration.tsp.ConfigurationTSP;

/**
 * 
 * @author Rodrigo Lira
 *
 */

public class GATSP {
	public static int COUNTER = 0;
	public static boolean DEBUG = false;
	private ConfigurationTSP configuration;
	private List<GeneTSP> individuos;
	private Random random;
	
	public GATSP(ConfigurationTSP c){
		this.configuration = c;
		int count = 0;
		this.random = new Random();
		individuos = new LinkedList<GeneTSP>();
		
		while (count < configuration.getIndividiuosQuantity()){
			GeneTSP g = new GeneTSP(GATSP.COUNTER, c);
			g.generateIndividual();
			individuos.add(g);			
			count += 1;
			GATSP.COUNTER += 1;
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
			System.out.println("IT=" + count  + " FIT=" + this.getIndividuos().get(0).getFitness());
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
		List<GeneTSP> children = new LinkedList<GeneTSP>();
		List<GeneTSP> tempChild = null;
		while (count < configuration.getCrossoverQuantity()){
			GeneTSP father = configuration.getParSelection().select(this.individuos);
			GeneTSP mother = configuration.getParSelection().select(this.individuos, father);
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
		for (GeneTSP g : individuos){
			g.mutation();
		}
	}
	
	
	public ConfigurationTSP getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ConfigurationTSP configuration) {
		this.configuration = configuration;
	}

	public List<GeneTSP> getIndividuos() {
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
		for (GeneTSP g : individuos){
			result.append(g);
		}
		return result.toString();
	}
}
