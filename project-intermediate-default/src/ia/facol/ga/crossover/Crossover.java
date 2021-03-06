package ia.facol.ga.crossover;

import ia.facol.ga.genetic.Chromosome;

import java.util.LinkedList;
import java.util.Random;

public abstract class Crossover {
	
	private Random random;
	
	public Crossover() {
		setRandom(new Random());
	}
	
	public abstract LinkedList<Chromosome> crossover(Chromosome geneA, Chromosome geneB);

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
