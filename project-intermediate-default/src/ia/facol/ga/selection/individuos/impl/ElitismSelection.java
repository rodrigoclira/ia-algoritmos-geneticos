package ia.facol.ga.selection.individuos.impl;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.genetic.Chromosome;
import ia.facol.ga.selection.individuos.IndividuosSelection;
import ia.facol.ga.util.Util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ElitismSelection extends IndividuosSelection{

	private double percentage = 0.1;
	@Override
	public List<Chromosome> select(List<Chromosome> genes, Configuration configuration) {
		
		int quantity = (int) Math.ceil(percentage * genes.size());
		List<Chromosome> newPopulation = new LinkedList<Chromosome>();

		/* TODO
		 * Retornar a nova população após a seleção elitista.
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
