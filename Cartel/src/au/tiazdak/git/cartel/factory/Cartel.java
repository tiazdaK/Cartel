package au.tiazdak.git.cartel.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cartel {
	//Cartel base class, holds all required data for the plugin
	//A player rank of 1 = admin, -2 = invited, -1 = applied.
	
	
	private int cartelID;
	private String cartelName;
	private HashMap<Integer, List<String>> players = new HashMap<>();
	
	
	
	private boolean existent;
	
	public int getID() {return cartelID;}
	public String getName() {return cartelName;}
	
	
	
	
	public void setName(String name) {cartelName = name;}
	
	
	public void setExistence(boolean existence) {existent = existence;}	
	
	public Cartel(int ID) {
		setupLevels();
		cartelID = ID;
		existent = true;
	}
	
	
	private void setupLevels() {
		List<String> p = new ArrayList<>();
		players.put(0, p);
		
	}
	
	public List<String> getPlayers() {
		List<String> allPlayers = new ArrayList<>();
		List<String> currentCollection = new ArrayList<>();
		int i = -2;
		while(true) {
			currentCollection = players.get(i);
			allPlayers.addAll(allPlayers.size(), currentCollection);
			if(i == 3) 
				break;
			i++;
		}
		return allPlayers;
	}
	
	@Override
	public String toString() {
		return cartelID + " " + cartelName;		
	}
}
