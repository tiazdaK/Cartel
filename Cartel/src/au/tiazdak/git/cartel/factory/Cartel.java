package au.tiazdak.git.cartel.factory;

public class Cartel {
	//Cartel base class, holds all required data for the plugin
	
	
	private int cartelID;
	private String cartelName;
	
	
	private boolean existent;
	
	public int getID() {return cartelID;}
	public String getName() {return cartelName;}
	
	
	
	
	
	public void setExistence(boolean existence) {existent = existence;}	
	
	public Cartel(int ID) {
		cartelID = ID;
		existent = true;
	}
	
	
	
}
