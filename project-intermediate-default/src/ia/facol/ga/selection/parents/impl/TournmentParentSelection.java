package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class TournmentParentSelection extends ParentSelection{

	@Override
	public Gene select(List<Gene> genes, Gene mother) {		

		/* TODO
		 * Selecionar um Gene utilizando a seleção por torneio 
		 */
		
		return null;

	}

	@Override
	public Gene select(List<Gene> genes) {
		return select(genes, null);
	}

}
