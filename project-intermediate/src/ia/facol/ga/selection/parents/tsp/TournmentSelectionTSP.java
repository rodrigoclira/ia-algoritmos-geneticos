package ia.facol.ga.selection.parents.tsp;

import ia.facol.ga.genetic.tsp.ChromosomeTSP;
import ia.facol.ga.selection.parents.tsp.ParentSelectionTSP;
import java.util.List;
import java.util.Random;

public class TournmentSelectionTSP  extends ParentSelectionTSP{

	private Random random = new Random();
	
	public ChromosomeTSP select(List<ChromosomeTSP> genes, ChromosomeTSP mother) {
				
		
		/* TODO
		 * Selecionar um Gene utilizando a seleção por torneio 
		 */
		
		return null;

	}

	@Override
	public ChromosomeTSP select(List<ChromosomeTSP> genes) {
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
