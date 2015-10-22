package ia.facol.ga.selection.individuos.impl.tsp;

import ia.facol.ga.configuration.tsp.ConfigurationTSP;
import ia.facol.ga.genetic.tsp.GeneTSP;
import ia.facol.ga.util.Util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ElitismSelectionTSP extends IndividuosSelectionTSP {
	private double percentage = 0.1;
	
	@Override
	public List<GeneTSP> select(List<GeneTSP> genes, ConfigurationTSP configuration) {
		
		int quantity = (int) Math.ceil(percentage * genes.size());
		
		List<GeneTSP> newPopulation = new LinkedList<GeneTSP>();

		/* TODO
		 * Retorna a nova população após a seleção elitista.
		 * 1. Obter os "quantity" melhores genes.
		 * 2. Escolher o resto de acordo com a roleta. 
		 */
				
		return newPopulation;
	}
	
	public double getPercentage() {
		return percentage;
	}
	
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}
