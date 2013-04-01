package au.tiazdak.git.cartel.factory;

import java.util.ArrayList;
import java.util.List;

import au.tiazdak.git.cartel.util.Logger;

public class CartelFactory {
	//Factory to interact with Cartels
	
	private Logger log = new Logger();
	
	private int highestCartelNum = 0;
	private List<Cartel> cartelCollection = new ArrayList<>();
	
	public void createCartel(String name, String player) {
		//Creates a cartel
		Cartel tempCartel = new Cartel(getFreeID());
		//Assign appropriate data
		tempCartel.setName(name);
		addPlayerToCartel(tempCartel, player, 1);
		//Finish up and cleanup
		cartelCollection.add(tempCartel);
		log.logInfo("Cartel has been created: " + tempCartel.getName());
		tempCartel = null;
	}
	
	public void deleteCartel(Cartel c) {
		//Delete a cartel (Remains on disc till cleanup).
		if(cartelCollection.contains(c)) {
			cartelCollection.remove(c);			
		} else {
			log.logWarning("Cartel could not be deleted", c.toString());			
		}		
	}
	
	//Data retrieval
	
	public Cartel getCartel(int iD) {
		//Gets the cartel with the matching iD
		for (Cartel c : cartelCollection) {
			if(c.getID() == iD) {
				return c;
			}
		}
		log.logWarning("Could not find cartel with ID: " + iD);
		return null;		
	}
	
	public Cartel getCartel(String player) {
		//Gets the cartel with the matching player
		for (Cartel c : cartelCollection) {
			for(String s : c.getPlayers()) {
				if(s.equals(player)) {
					return c;
				}				
			}
		}
		log.logWarning("Could not find cartel with player: " + player);
		return null;			
	}
	
	private int getFreeID() {
		return highestCartelNum + 1;
	}
	
	//PlayerInteraction
	
	public void changePlayerRank(Cartel c, String player, int playerRank) {		
		
	}
	
	public void addPlayerToCartel(Cartel c, String player, int playerRank) {
		
	}
	
	public void removePlayerFromCartel(Cartel c, String player) {
		
	}
	
	public int getPlayerRank(Cartel c, String player) {
		return 0;
	}
	
	//Read/Write Interaction	
	
	public void readCartelsFromDisc() {
		
	}
	
	public void writeCartelsToDisc() {
		
	}	
}
