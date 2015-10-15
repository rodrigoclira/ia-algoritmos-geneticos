package ia.facol.ga.crossover;

import ia.facol.ga.genetic.Gene;

import java.util.LinkedList;
import java.util.Random;

public abstract class Crossover {
	
	private Random random;
	
	public Crossover() {
		// TODO Auto-generated constructor stub
		setRandom(new Random());
	}
	
	public abstract LinkedList<Gene> crossover(Gene geneA, Gene geneB);

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public String toString(){
		return this.getClass().getCanonicalName();
	}
}
