package ia.facol.ga.mutation;

import java.util.Random;

import ia.facol.ga.genetic.Gene;

public abstract class Mutation {
	
	private Random random;
	
	public Mutation(){
		this.setRandom(new Random());
	}
	
	public abstract void mutate(Gene gene, int position);

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public String toString(){
		return this.getClass().getName();
	}
}
