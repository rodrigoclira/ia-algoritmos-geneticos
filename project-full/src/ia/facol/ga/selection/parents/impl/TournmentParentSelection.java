package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class TournmentParentSelection extends ParentSelection{

	@Override
	public Gene select(List<Gene> genes, Gene mother) {
		
		RandomParentSelection randomParent = new RandomParentSelection();
		
		Gene ind1 = randomParent.select(genes, mother);
		Gene ind2 = randomParent.select(genes, ind1);
		
		// Minimização
		if (ind1.getFitness() <= ind2.getFitness()){
			return ind1;
		}else{
			return ind2;
		}

	}

	@Override
	public Gene select(List<Gene> genes) {
		// TODO Auto-generated method stub
		return select(genes, null);
	}

}
