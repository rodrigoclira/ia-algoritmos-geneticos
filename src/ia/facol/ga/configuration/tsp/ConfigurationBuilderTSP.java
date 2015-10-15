package ia.facol.ga.configuration.tsp;

import ia.facol.ga.crossover.impl.tsp.CrossOverTwoPointsTSP;
import ia.facol.ga.mutation.impl.tsp.SwapMutation;
import ia.facol.ga.selection.individuos.impl.tsp.IndividuosSelectionTSP;
import ia.facol.ga.selection.parents.ParentSelectionTSP;
import ia.facol.problems.tsp.TSPProblem;


public class ConfigurationBuilderTSP {
	
	private ConfigurationTSP configuration;
	
	public ConfigurationBuilderTSP(){
		this.configuration = new ConfigurationTSP();
	}
	
	public ConfigurationBuilderTSP buildIndividuosQuantity(int ind){
		this.configuration.setIndividiuosQuantity(ind);
		return this;
	}
	
	public ConfigurationBuilderTSP buildCrossoverQuantity(int qtyCrossover){
		this.configuration.setCrossoverQuantity(qtyCrossover);
		return this;
	}
	
	public ConfigurationBuilderTSP buildMutationRate(double mutationRate){
		this.configuration.setMutationRate(mutationRate);
		return this;
	}
	
	public ConfigurationBuilderTSP buildCrossoverRate(double crossoverRate){
		this.configuration.setCrossoverRate(crossoverRate);
		return this;
	}
	
	public ConfigurationBuilderTSP buildCrossoverType(CrossOverTwoPointsTSP crossType){
		this.configuration.setCrossoverType(crossType);
		return this;
	}

	public ConfigurationBuilderTSP buildMutationType(SwapMutation mutationType){
		this.configuration.setMutation(mutationType);
		return this;
	}
	
	public ConfigurationBuilderTSP buildProblemable(TSPProblem problem){
		this.configuration.setProblem(problem);
		return this;
	}

	public ConfigurationBuilderTSP buildIndSelection(IndividuosSelectionTSP selection){
		this.configuration.setIndSelection(selection);
		return this;
	}
	
	public ConfigurationBuilderTSP buildParentSelection(ParentSelectionTSP selection){
		this.configuration.setParSelection(selection);
		return this;
	}
	
	
	public ConfigurationTSP getConfiguration(){
		return this.configuration;
	}
		
}
