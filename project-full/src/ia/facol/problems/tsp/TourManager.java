package ia.facol.problems.tsp;

import java.util.ArrayList;

public class TourManager {
	

    // Cidades
    private static ArrayList<City> destinationCities = new ArrayList<City>();

    // Adiciona uma cidade
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Retorna uma cidade
    public static City getCity(int index){
        return destinationCities.get(index);
    }
    
    // Retorna a quantidade de cidades
    public static int numberOfCities(){
        return destinationCities.size();
    }

}
