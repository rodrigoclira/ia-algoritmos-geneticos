package ia.facol.ga.selection.individuos.impl;

import ia.facol.ga.configuration.Configuration;
import ia.facol.ga.genetic.Gene;
import ia.facol.ga.selection.individuos.IndividuosSelection;
import ia.facol.ga.util.Util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ElitismSelection extends IndividuosSelection{

	private double percentage = 0.1;
	@Override
	public List<Gene> select(List<Gene> genes, Configuration configuration) {
		
		int quantity = (int) Math.ceil(percentage * genes.size());
		
		//List<Gene> newPopulation = genes.subList(0, quantity);
		List<Gene> newPopulation = new LinkedList<Gene>();
		int count = 0;
		for (Iterator<Gene> i = genes.iterator(); i.hasNext();) {
			  Gene g = i.next();
			  
			  count += 1;			  
			  if (count > quantity){
				  break;
			  }
			  newPopulation.add(g);
		}
		
		List<Gene> population = genes.subList(quantity, genes.size());
		List<Gene> roulete = Util.rouleteWheel(population, configuration.getIndividiuosQuantity() - quantity);
		
		newPopulation.addAll(roulete);	
		
		
		return newPopulation;
	}
	
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
