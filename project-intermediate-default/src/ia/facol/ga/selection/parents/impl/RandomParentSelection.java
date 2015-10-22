package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class RandomParentSelection extends ParentSelection{

	@Override
	public Gene select(List<Gene> genes, Gene mother) {
		Gene geneChosen = null;
		/* TODO
		 *  Selecionar um pai aleatoriamente.
		 *  Atentar para não selecionar um pai que já foi escolhido como mãe.
		 */
		return geneChosen;
		
	}
	
	public Gene select(List<Gene> genes) {
		return this.select(genes, null);
	}
	
	

}
