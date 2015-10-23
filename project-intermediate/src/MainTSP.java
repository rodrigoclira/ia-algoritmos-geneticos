import ia.facol.ga.configuration.tsp.ConfigurationBuilderTSP;
import ia.facol.ga.configuration.tsp.ConfigurationTSP;
import ia.facol.ga.crossover.tsp.CrossOverTwoPointsTSP;
import ia.facol.ga.genetic.tsp.GATSP;
import ia.facol.ga.mutation.impl.tsp.SwapMutation;
import ia.facol.ga.selection.individuos.impl.tsp.ElitismSelectionTSP;
import ia.facol.ga.selection.parents.tsp.TournmentSelectionTSP;
import ia.facol.problems.tsp.City;
import ia.facol.problems.tsp.TSPProblem;
import ia.facol.problems.tsp.TourManager;



public class MainTSP {
	public static void main(String[] args) {
		
		ConfigurationBuilderTSP cb = new ConfigurationBuilderTSP();		
		ConfigurationTSP c = 
				cb.buildCrossoverQuantity(10)
				.buildCrossoverRate(0.7)
				.buildCrossoverType(new CrossOverTwoPointsTSP())
				.buildMutationType(new SwapMutation())			
				.buildIndividuosQuantity(30)
				.buildMutationRate(0.15)
				.buildProblemable(new TSPProblem())
				.buildIndSelection(new ElitismSelectionTSP())
				.buildParentSelection(new TournmentSelectionTSP())
				.getConfiguration();
		
        // Create and add our cities
        City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);
        
        GATSP ga = new GATSP(c);
        ga.sort();
        
        ga.run(50000);
        System.out.println(ga);
        
        //BR 863
        // (999885) | FIT = 863.000 | INFO = [ 60, 80 ; 40, 120 ; 20, 160 ; 60, 200 ; 80, 180 ; 100, 160 ; 100, 120 ; 140, 140 ; 140, 180 ; 180, 200 ; 200, 160 ; 180, 100 ; 180, 60 ; 200, 40 ; 160, 20 ; 120, 80 ; 100, 40 ; 60, 20 ; 20, 20 ; 20, 40 ;  ]

       

	}
}
