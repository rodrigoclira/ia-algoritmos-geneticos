package ia.facol.ga.configuration;

import ia.facol.ga.crossover.Crossover;
import ia.facol.ga.mutation.Mutation;
import ia.facol.ga.selection.individuos.IndividuosSelection;
import ia.facol.ga.selection.parents.ParentSelection;
import ia.facol.problems.benchmark.Problemable;


public class ConfigurationBuilder {
	
	private Configuration configuration;
	
	public ConfigurationBuilder(){
		this.configuration = new Configuration();
	}
	
	public ConfigurationBuilder buildIndividuosQuantity(int ind){
		this.configuration.setIndividiuosQuantity(ind);
		return this;
	}
	
	public ConfigurationBuilder buildCrossoverQuantity(int qtyCrossover){
		this.configuration.setCrossoverQuantity(qtyCrossover);
		return this;
	}
	
	public ConfigurationBuilder buildMutationRate(double mutationRate){
		this.configuration.setMutationRate(mutationRate);
		return this;
	}
	
	public ConfigurationBuilder buildCrossoverRate(double crossoverRate){
		this.configuration.setCrossoverRate(crossoverRate);
		return this;
	}
	
	public ConfigurationBuilder buildCrossoverType(Crossover crossType){
		this.configuration.setCrossoverType(crossType);
		return this;
	}

	public ConfigurationBuilder buildMutationType(Mutation mutationType){
		this.configuration.setMutation(mutationType);
		return this;
	}
	
	public ConfigurationBuilder buildProblemable(Problemable problem){
		this.configuration.setProblem(problem);
		return this;
	}

	public ConfigurationBuilder buildIndSelection(IndividuosSelection selection){
		this.configuration.setIndSelection(selection);
		return this;
	}
	
	public ConfigurationBuilder buildParentSelection(ParentSelection selection){
		this.configuration.setParSelection(selection);
		return this;
	}
	
	
	public Configuration getConfiguration(){
		return this.configuration;
	}
		
}
