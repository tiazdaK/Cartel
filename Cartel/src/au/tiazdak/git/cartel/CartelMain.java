package au.tiazdak.git.cartel;

import org.bukkit.plugin.java.JavaPlugin;

import au.tiazdak.git.cartel.factory.CartelFactory;
import au.tiazdak.git.cartel.util.Logger;

/*
 * Author: tiazdaK
 * Description: Cartel is a bukkit plugin which outlines an alternative 
 * 				way of team based player versus player combat.
 * Initial Commit: 01/04/2013
 */

public class CartelMain extends JavaPlugin {
	
	public CartelFactory cartelFactory = new CartelFactory();
	private Logger log = new Logger();
	
	
	@Override
	public void onEnable() {
		log.logInfo("Cartel has been enabled");
		
		//Create the cartels file/populate it
		cartelFactory.getCartelsOnDisc();
		cartelFactory.loadCartels();
		
	
	}

	@Override
	public void onDisable() {
		
	}
}
