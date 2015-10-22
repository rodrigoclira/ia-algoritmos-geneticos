package ia.facol.ga.selection.individuos;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.genetic.Gene;

import java.util.List;

public abstract class IndividuosSelection {
	
	public abstract List<Gene> select(List<Gene> genes, Configuration configuration);
	
	public String toString(){
		return this.getClass().getName();
	}
}
