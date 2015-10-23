package ia.facol.ga.selection.parents;

import ia.facol.ga.genetic.Chromosome;

import java.util.List;
import java.util.Random;

public abstract class ParentSelection {
	
	private Random random = new Random();
	
	public abstract Chromosome select(List<Chromosome> genes, Chromosome mother);
	public abstract Chromosome select(List<Chromosome> genes);

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
