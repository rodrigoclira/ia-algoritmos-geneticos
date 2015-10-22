package ia.facol.problems.tsp;

import java.util.List;

public class TSPProblem {
	public int evaluate(List<City> tour){		
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tour.size(); cityIndex++) {
                // Get city we're travelling from
                City fromCity = tour.get(cityIndex);
                // City we're travelling to
                City destinationCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tour.size()){
                    destinationCity =  tour.get(cityIndex+1);
                }
                else{
                    destinationCity =  tour.get(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.distanceTo(destinationCity);
            }
	        return tourDistance; 
	}
}
