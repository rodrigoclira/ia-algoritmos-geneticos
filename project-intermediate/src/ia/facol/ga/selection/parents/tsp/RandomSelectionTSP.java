package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.ga.selection.parents.tsp.ParentSelectionTSP;

import java.util.List;
import java.util.Random;

public class RandomSelectionTSP extends ParentSelectionTSP{

	private Random random = new Random();
	
	public GeneTSP select(List<GeneTSP> genes, GeneTSP mother) {

			GeneTSP geneChosen = null;
			/* TODO
			 *  Selecionar um pai aleatoriamente.
			 *  Atentar para não selecionar um pai que já foi escolhido como mãe.
			 */
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
