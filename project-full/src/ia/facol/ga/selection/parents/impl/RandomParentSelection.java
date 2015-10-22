package ia.facol.ga.selection.parents.impl;

import ia.facol.ga.genetic.Gene;
import ia.facol.ga.selection.parents.ParentSelection;

import java.util.List;

public class RandomParentSelection extends ParentSelection{

	@Override
	public Gene select(List<Gene> genes, Gene mother) {
		Gene geneChosen = null;
		int value = 0;
		do{
			value = getRandom().nextInt(genes.size());
			geneChosen =  genes.get(value);
			
		}while(mother != null && genes.get(value).getId() == mother.getId());
		/*		
		if (mother == null){
		
			geneChosen =  genes.get(value);
		
		}else{
		
			while (genes.get(value).getId() == mother.getId()){
				value = getRandom().nextInt(genes.size() - 1);
				geneChosen =  genes.get(value);
			}
		}
		
		*/
		
		return geneChosen;
		
	}
	
	public Gene select(List<Gene> genes) {
		return this.select(genes, null);
	}
	
	

}
