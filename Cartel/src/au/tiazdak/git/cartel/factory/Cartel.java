package au.tiazdak.git.cartel.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import au.tiazdak.git.cartel.CartelMain.RelationShip;
import au.tiazdak.git.cartel.util.Logger;

public class Cartel {
	//Cartel base class, holds all required data for the plugin
	//A player rank of 1 = admin, -2 = invited, -1 = applied
	
	private Logger log = new Logger();
	
	private int cartelID;
	private String cartelName;
	private String plot;
	private double influence;
	private HashMap<Integer, List<String>> players = new HashMap<>();
	private HashMap<Integer, RelationShip> cartelRelations = new HashMap<>();
	
	private boolean existent;
	
	//Getters
	public int getID() {return cartelID;}
	public String getName() {return cartelName;}
	public String getPlot() {return plot;}
	public double getInfluence() { return influence; }
	public boolean getExistence() { return existent; }
	public HashMap<Integer, List<String>> getAllPlayers() { return players; }
	public HashMap<Integer, RelationShip> getAllRelations() { return cartelRelations; }
	
	//Setters
	public void setName(String name) {cartelName = name;}
	public void setInfluence(double d) { influence = d; }
	public void setExistence(boolean existence) {existent = existence;}	
	
	//Creation Mechanics
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
	
	//Player Management
	
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
	
	//RelationShip Management
	public RelationShip getRelationShipWithID(int id) {
		//Gets the relationship with the certain id
		if(cartelRelations.containsKey(id)) {
			return cartelRelations.get(id);
		} else {
			return RelationShip.noEntry;
		}
	}
	
	public void setRelationShipWithID(int id, RelationShip relation) {
		//Sets the relationship with the id
		if(id != cartelID && relation != RelationShip.thisCartel && relation != RelationShip.noEntry) {
			cartelRelations.put(id, relation);
		}		
	}
	
	//Plot Management
	public void setPlot(String input) {
		plot = input;		
	}
	
	//Overwrites
	
	public void overwritePlayers(HashMap<Integer, List<String>> input) {
		players = input;
	}
	
	public void overwriteRelations(HashMap<Integer, RelationShip> input) {
		//Overwrites all of the Cartels Relations
		cartelRelations = input;
	}
	
	//Overrides
	@Override
	public String toString() {
		return cartelID + " " + cartelName;		
	}
}
