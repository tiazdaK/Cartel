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
		players.put(-2, p);
		players.put(-1, p);
		players.put(1, p);
		players.put(2, p);
		players.put(3, p);		
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
	
	public void setPlayers(List<String> p, int rank) {
		//Sets players in a single part of "players"
		players.put(rank, p);
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
	
	public int getPlayerRank(String name) {
		//Returns the rank of the player.
		int i = -2;
		while(true) {
			if(players.get(i).contains(name)) {
				return i;
			}
			if(i == 3) 
				break;
			i++;
		}
		return 0;
	}
	
	public boolean isPlayerInCartel(String name) {
		//Checks if a player is in that cartel.
		if(getPlayers().contains(name)) {
			return true;
		}
		return false;		
	}
	
	//Writing/Reading to/from disc.
	public List<String> writeToDisc() {
		//Writes all data to the ArrayList allowing it to be put to disc.
		List<String> toDisc = new ArrayList<>();
		//Get High Information.
		toDisc.add("CartelID." + Integer.toString(cartelID));
		toDisc.add("CartelName." + cartelName);
		toDisc.add("CartelExistance." + Boolean.toString(existent));		
		//Get Players
		for(int i = -2; i != 4; i++) {
			if(!players.get(i).isEmpty()) {
				for(int x = 0; x != players.get(i).size(); x++) {
					toDisc.add(players.get(i).get(x));
				}
			}
		}
		//Return data
		return toDisc;
	}
	
	public void readFromDisc(List<String> data) {
		//Reads the data from disc and puts it into the cartel.
		//Retrieve High data
		cartelID = Integer.parseInt(data.get(0));
		cartelName = data.get(1);
		existent = Boolean.parseBoolean(data.get(2));
		//Get Players
		
		//Need to work out method to load from disc.
	}
	
	//Overrides
	@Override
	public String toString() {
		return cartelID + " " + cartelName;		
	}
}
