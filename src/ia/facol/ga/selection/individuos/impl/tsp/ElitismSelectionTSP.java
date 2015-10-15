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
		
		//List<Gene> newPopulation = genes.subList(0, quantity);
		List<GeneTSP> newPopulation = new LinkedList<GeneTSP>();
		int count = 0;
		for (Iterator<GeneTSP> i = genes.iterator(); i.hasNext();) {
			  GeneTSP g = i.next();
			  
			  count += 1;			  
			  if (count > quantity){
				  break;
			  }
			  newPopulation.add(g);
		}
		
		List<GeneTSP> population = genes.subList(quantity, genes.size());
		List<GeneTSP> roulete = Util.rouleteWheelTSP(population, configuration.getIndividiuosQuantity() - quantity);
		
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
