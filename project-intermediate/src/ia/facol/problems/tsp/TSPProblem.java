package ia.facol.problems.tsp;

import java.util.List;

public class TSPProblem {
	public int evaluate(List<City> tour){		
            int tourDistance = 0;
            // loop através das cidades
            for (int cityIndex=0; cityIndex < tour.size(); cityIndex++) {
                // Pegar a cidade atual
                City fromCity = tour.get(cityIndex);
                // Pegar a cidade destino
                City destinationCity;
                // Checa se estamos na última cidadem se estivermos nós vamos setar o 
                // a cidade finla como a cidade inicial
                if(cityIndex+1 < tour.size()){
                    destinationCity =  tour.get(cityIndex+1);
                }
                else{
                    destinationCity =  tour.get(0);
                }
                // calcular a distância entre as duas cidades
                tourDistance += fromCity.distanceTo(destinationCity);
            }
	        return tourDistance; 
	}
}
