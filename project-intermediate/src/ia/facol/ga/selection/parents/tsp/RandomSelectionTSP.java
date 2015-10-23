package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.ChromosomeTSP;
import ia.facol.ga.selection.parents.tsp.ParentSelectionTSP;

import java.util.List;
import java.util.Random;

public class RandomSelectionTSP extends ParentSelectionTSP{

	private Random random = new Random();
	
	public ChromosomeTSP select(List<ChromosomeTSP> genes, ChromosomeTSP mother) {

			ChromosomeTSP geneChosen = null;
			/* TODO
			 *  Selecionar um pai aleatoriamente.
			 *  Atentar para não selecionar um pai que já foi escolhido como mãe.
			 */
			return geneChosen;

	}

	public ChromosomeTSP select(List<ChromosomeTSP> genes) {
		return this.select(genes, null);
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}


}
