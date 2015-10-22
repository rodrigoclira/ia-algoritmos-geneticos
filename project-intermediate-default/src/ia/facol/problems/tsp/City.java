package ia.facol.problems.tsp;

public class City {
	private int x;
	private int y;
	private static int COUNT = 0;
	private int id;
	
	public City(){
		this.x = (int) (Math.random() * 200);
		this.y = (int) (Math.random() * 200);
		id = COUNT;
		COUNT+=1;
	}
	
	public City(int x, int y){
		this.x = x;
		this.y = y;
		id = COUNT;
		COUNT+=1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	} 
	
	public int getCount(){
		return COUNT;
	}
	
	public int getId(){
		return id;
	}
	
	/**
	 * Distância euclidiana
	 * @param city
	 * @return
	 */
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getX()+", " + getY();
    }
    
    public boolean isTheSame(City city){
    	return (this.x == city.x) && (this.y == city.y); 
    }
}
