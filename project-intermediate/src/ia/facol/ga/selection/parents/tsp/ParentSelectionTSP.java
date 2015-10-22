package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.GeneTSP;

import java.util.List;
import java.util.Random;

public abstract class ParentSelectionTSP {
	private Random random = new Random();
	
	public abstract GeneTSP select(List<GeneTSP> genes, GeneTSP mother);
	public abstract GeneTSP select(List<GeneTSP> genes);

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
