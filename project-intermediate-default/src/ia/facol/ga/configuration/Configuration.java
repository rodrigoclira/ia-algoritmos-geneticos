package ia.facol.ga.configuration;

import ia.facol.ga.crossover.Crossover;
import ia.facol.ga.mutation.Mutation;
import ia.facol.ga.selection.individuos.IndividuosSelection;
import ia.facol.ga.selection.parents.ParentSelection;
import ia.facol.problems.benchmark.Problemable;

public class Configuration {

	private int individiuosQuantity;
	private int crossoverQuantity;
	private double mutationRate;
	private double crossoverRate;
	private Crossover crossover;
	private Problemable problem;
	private Mutation mutation;
	private IndividuosSelection indSelection;
	private ParentSelection  parSelection;
	
	public int getIndividiuosQuantity(){
		return individiuosQuantity;
	}
	
	void setIndividiuosQuantity(int ind){
		this.individiuosQuantity = ind;
	}
	
	public int getCrossoverQuantity(){
		return crossoverQuantity;
	}
	
	void setCrossoverQuantity(int crossQty){
		this.crossoverQuantity = crossQty;
	}
	
	public double getMutationRate(){
		return mutationRate;
	}
	
	void setMutationRate(double mutationR){
		this.mutationRate = mutationR;
	}
	
	public double getCrossoverRate(){
		return crossoverRate;
	}
	
	void setCrossoverRate(double crossR){
		this.crossoverRate = crossR;
	}
	
	public Crossover getCrossoverType(){
		return crossover;
	}
	
	void setCrossoverType(Crossover crossover){
		this.crossover = crossover;
	}
	
	public Problemable getProblem(){
		return problem;
	}
	
	public void setProblem(Problemable problem){
		this.problem = problem;
	}
	
	public Mutation getMutation(){
		return this.mutation;
	}
	
	public void setMutation(Mutation mutation){
		this.mutation = mutation;
	}
	
	public String toString(){
		String result= String.format("Individuos: %d\nCrossover Quantity: %d\nMutation Rate: %.2f\nCrossover Rate: %.2f\nCrossover: %s\nMutation: %s\nParent Selection> %s\nIndividuos Selection: %s\nProblem: %s\n", 
				this.individiuosQuantity, this.crossoverQuantity, this.mutationRate, this.crossoverRate, this.crossover, this.mutation, this.parSelection, this.indSelection, this.problem);
		return result;
	}

	public IndividuosSelection getIndSelection() {
		return indSelection;
	}

	public void setIndSelection(IndividuosSelection indSelection) {
		this.indSelection = indSelection;
	}

	public ParentSelection getParSelection() {
		return parSelection;
	}

	public void setParSelection(ParentSelection parSelection) {
		this.parSelection = parSelection;
	}
}
