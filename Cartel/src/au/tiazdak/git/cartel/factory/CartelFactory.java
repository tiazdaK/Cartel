package au.tiazdak.git.cartel.factory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import au.tiazdak.git.cartel.CartelMain.RelationShip;
import au.tiazdak.git.cartel.CartelMain;
import au.tiazdak.git.cartel.util.Logger;

public class CartelFactory {
	//Factory to interact with Cartels
	
	private Logger log = new Logger();
	private CartelMain cm = new CartelMain();
	
	private FileConfiguration cartelConfig = null;
	private File cartelConfigFile = null;
	
	private int highestCartelNum = 0;
	private List<Cartel> cartelCollection = new ArrayList<>();
	
	//Cartel Creation Control
	
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
	
	//Cartel Retrieval Commands
	
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
	
	//Cartel Player Control
	
	public void changePlayerRank(Cartel c, String player, int playerRank) {		
		c.removePlayer(player);
		c.addPlayer(player, playerRank);
	}
	
	public void addPlayerToCartel(Cartel c, String player, int playerRank) {
		c.addPlayer(player, playerRank);
	}
	
	public void removePlayerFromCartel(Cartel c, String player) {
		c.removePlayer(player);
	}
	
	public int getPlayerRank(Cartel c, String player) {
		return c.getPlayerRank(player);
	}
	
	//Cartel Plot Control
	public String getPlot(Cartel c) {
		return c.getPlot();
	}
	
	public void setPlot(Cartel c, String p) {
		c.setPlot(p);
	}	
	
	public HashMap<Integer, List<Double>> getPlotCorners(Cartel c) {
		//XXX
		return null;
	}
	
	//Cartel Relationship Control
	
	public RelationShip getRelationship(Cartel c1, Cartel c2) {
		return c1.getRelationShipWithID(c2.getID());
	}
	
	public void setRelationShip(Cartel c1, Cartel c2, RelationShip r) {
		c1.setRelationShipWithID(c2.getID(), r);
	}
	
	//Cartel Access Control
	
	public double compareInfluence(Cartel c1, Cartel c2) {
		return c1.getInfluence() - c2.getInfluence();
	}
	
	//Cartel Data Management
	
	public void loadCartels() {
		//XXX
		
	}
	
	public void writeToCartels() {
		//XXX
		
	}
	
	public List<Cartel> readFromCartels() {
		//XXX
		return null;
	}
	
	//Cartel Disk Management	
	
	public void getCartelsOnDisc() { 
		if (cartelConfigFile == null) {
			cartelConfigFile = new File(cm.getDataFolder(), "cartelData.yml");
	    }
	    cartelConfig = YamlConfiguration.loadConfiguration(cartelConfigFile);
		InputStream defConfigStream = cm.getResource("cartelData.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        	cartelConfig.setDefaults(defConfig);
		}
		
	}
	
	public FileConfiguration readCartelsFromDisc() {
		if (cartelConfig == null) {
	        this.getCartelsOnDisc();
	    }
	    return cartelConfig;
	}
	
	public void writeCartelsToDisc() throws IOException {
		if (cartelConfig == null || cartelConfigFile == null) {
		    return;
		}
		readCartelsFromDisc().save(cartelConfigFile);
	}	
}
