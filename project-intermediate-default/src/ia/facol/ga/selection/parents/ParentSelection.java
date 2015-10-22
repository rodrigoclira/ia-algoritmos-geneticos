package ia.facol.ga.selection.parents;

import ia.facol.ga.genetic.Gene;

import java.util.List;
import java.util.Random;

public abstract class ParentSelection {
	
	private Random random = new Random();
	
	public abstract Gene select(List<Gene> genes, Gene mother);
	public abstract Gene select(List<Gene> genes);

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
