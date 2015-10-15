package ia.facol.ga.selection.individuos.impl.tsp;

import ia.facol.ga.configuration.tsp.ConfigurationTSP;
import ia.facol.ga.genetic.tsp.GeneTSP;

import java.util.List;

public abstract class IndividuosSelectionTSP  {
	public abstract List<GeneTSP> select(List<GeneTSP> genes, ConfigurationTSP configuration);

	public String toString(){
		return this.getClass().getName();
	}
}
