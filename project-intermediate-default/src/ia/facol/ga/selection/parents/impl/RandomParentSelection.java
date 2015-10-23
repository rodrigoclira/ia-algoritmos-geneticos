package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Chromosome;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class RandomParentSelection extends ParentSelection{

	@Override
	public Chromosome select(List<Chromosome> genes, Chromosome mother) {
		Chromosome geneChosen = null;
		/* TODO
		 *  Selecionar um pai aleatoriamente.
		 *  Atentar para não selecionar um pai que já foi escolhido como mãe.
		 */
		return geneChosen;
		
	}
	
	public Chromosome select(List<Chromosome> genes) {
		return this.select(genes, null);
	}
	
	

}
