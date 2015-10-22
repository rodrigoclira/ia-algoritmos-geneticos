package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.ga.selection.parents.ParentSelectionTSP;
import java.util.List;
import java.util.Random;

public class TournmentSelectionTSP  extends ParentSelectionTSP{

	private Random random = new Random();
	
	public GeneTSP select(List<GeneTSP> genes, GeneTSP mother) {
		
		RandomSelectionTSP randomParent = new RandomSelectionTSP();
		
		GeneTSP ind1 = randomParent.select(genes, mother);
		GeneTSP ind2 = randomParent.select(genes, ind1);
		
		// Minimização
		if (ind1.getFitness() <= ind2.getFitness()){
			return ind1;
		}else{
			return ind2;
		}

	}

	@Override
	public GeneTSP select(List<GeneTSP> genes) {
		// TODO Auto-generated method stub
		return select(genes, null);
	}


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
