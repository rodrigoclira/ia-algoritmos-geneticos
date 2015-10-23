package ia.facol.ga.selection.individuos;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.genetic.Chromosome;

import java.util.List;

public abstract class IndividuosSelection {
	
	public abstract List<Chromosome> select(List<Chromosome> genes, Configuration configuration);
	
	public String toString(){
		return this.getClass().getName();
	}
}
