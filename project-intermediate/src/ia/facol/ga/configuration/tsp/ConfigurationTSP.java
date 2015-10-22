package ia.facol.ga.configuration.tsp;

import ia.facol.ga.crossover.tsp.CrossOverTwoPointsTSP;
import ia.facol.ga.mutation.impl.tsp.SwapMutation;
import ia.facol.ga.selection.individuos.impl.tsp.IndividuosSelectionTSP;
import ia.facol.ga.selection.parents.tsp.ParentSelectionTSP;
import ia.facol.problems.tsp.TSPProblem;

public class ConfigurationTSP {

	private int individiuosQuantity;
	private int crossoverQuantity;
	private double mutationRate;
	private double crossoverRate;
	private CrossOverTwoPointsTSP crossover;
	private TSPProblem problem;
	private SwapMutation mutation;
	private IndividuosSelectionTSP indSelection;
	private ParentSelectionTSP parSelection;
	
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
	
	public CrossOverTwoPointsTSP getCrossoverType(){
		return crossover;
	}
	
	void setCrossoverType(CrossOverTwoPointsTSP crossover){
		this.crossover = crossover;
	}
	
	public TSPProblem getProblem(){
		return problem;
	}
	
	public void setProblem(TSPProblem problem){
		this.problem = problem;
	}
	
	public SwapMutation getMutation(){
		return this.mutation;
	}
	
	public void setMutation(SwapMutation mutation){
		this.mutation = mutation;
	}
	
	public String toString(){
		String result= String.format("Individuos: %d\nCrossover Quantity: %d\nMutation Rate: %.2f\nCrossover Rate: %.2f\nCrossover: %s\nMutation: %s\nParent Selection> %s\nIndividuos Selection: %s\nProblem: %s\n", 
				this.individiuosQuantity, this.crossoverQuantity, this.mutationRate, this.crossoverRate, this.crossover, this.mutation, this.parSelection, this.indSelection, this.problem);
		//"\nCrossover Type: %s\nMutation Type: %s\nProblem: %s
		//, this.crossoverRate, this.crossover, this.mutation, this.problem
		return result;
	}

	public IndividuosSelectionTSP getIndSelection() {
		return indSelection;
	}

	public void setIndSelection(IndividuosSelectionTSP indSelection) {
		this.indSelection = indSelection;
	}

	public ParentSelectionTSP getParSelection() {
		return parSelection;
	}

	public void setParSelection(ParentSelectionTSP parSelection) {
		this.parSelection = parSelection;
	}
}