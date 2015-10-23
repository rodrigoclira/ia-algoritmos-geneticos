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
	private List<Chromosome> individuos;
	private Random random;
	
	public GA(Configuration c){
		this.configuration = c;
		int count = 0;
		this.random = new Random();
		double value = 0.0;
		individuos = new LinkedList<Chromosome>();
		
		/**
		 * TODO
		 * 1. Criar um novo gene
		 * 2. Gerar a informação genética aleatoriamente de acordo com os limites do problema
		 * 3. Adicionar a população
		 * 4. Atualizar informações excedentes
		 */
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
		List<Chromosome> children = new LinkedList<Chromosome>();
		List<Chromosome> tempChild = null;
		while (count < configuration.getCrossoverQuantity()){
			/* TODO
			 * 1. Escolher um pai
			 * 2. Escolher uma mãe
			 * 3. Executar o crossover
			 */
		}
		this.individuos.addAll(children);
	}
	
	
	public void sort(){
		//sort(false);
		sort(true);
	}
	
	private void mutation(){
		for (Chromosome g : individuos){
			g.mutation();
		}
	}
	
	
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public List<Chromosome> getIndividuos() {
		return individuos;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
	
	/*
	 * TODO
	 * Implementar um método que imprima toda a população
	 */
	public String toString(){
		return "";
	}
}
