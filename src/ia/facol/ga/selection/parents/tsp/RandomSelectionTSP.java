package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.ga.selection.parents.ParentSelectionTSP;

import java.util.List;
import java.util.Random;

public class RandomSelectionTSP extends ParentSelectionTSP{

	private Random random = new Random();
	
	public GeneTSP select(List<GeneTSP> genes, GeneTSP mother) {

		GeneTSP geneChosen = null;
		int value = 0;
		do{
			value = getRandom().nextInt(genes.size());
			geneChosen =  genes.get(value);

		}while(mother != null && genes.get(value).getId() == mother.getId());

		return geneChosen;

	}

	public GeneTSP select(List<GeneTSP> genes) {
		return this.select(genes, null);
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}


}
