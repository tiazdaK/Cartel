package au.tiazdak.git.cartel.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.tiazdak.git.cartel.util.Logger;

public class Cartel {
	//Cartel base class, holds all required data for the plugin
	//A player rank of 1 = admin, -2 = invited, -1 = applied.

	private Logger log = new Logger();
	
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
		
		log.logInfo(toString());
	}
	
	
	private void setupLevels() {
		List<String> p = new ArrayList<>();
		players.put(0, p);
		
	}
	
	public void addPlayer(String name, int rank) {
		//Add player to a cartel with specified rank.
		List<String> p = players.get(rank);
		p.add(name);
		players.remove(rank);
		players.put(rank, p);
	}
	
	public void removePlayer(String name) {
		//Remove player from cartel.
		List<String> p = new ArrayList<>();
		int i = -2;
		while(true) {
			p = players.get(i);
			if(p.contains(name)) {
				p.remove(name);
				players.put(i, p);
				return;
			}
			if(i == 3) 
				break;
			i++;
		}
		log.logInfo("Could not remove player '" + name + "' from cartel " + cartelName + ".");
	}
	
	public List<String> getPlayers() {
		//Returns a collection of all players.
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
	
	public boolean isPlayerInCartel(String name) {
		//Checks if a player is in that cartel.
		if(getPlayers().contains(name)) {
			return true;
		}
		return false;		
	}
	
	@Override
	public String toString() {
		return cartelID + " " + cartelName;		
	}
}
