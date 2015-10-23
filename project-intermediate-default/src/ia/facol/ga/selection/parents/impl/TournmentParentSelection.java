package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Chromosome;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class TournmentParentSelection extends ParentSelection{

	@Override
	public Chromosome select(List<Chromosome> genes, Chromosome mother) {		

		/* TODO
		 * Selecionar um Gene utilizando a seleção por torneio 
		 */
		
		return null;

	}

	@Override
	public Chromosome select(List<Chromosome> genes) {
		return select(genes, null);
	}

}
