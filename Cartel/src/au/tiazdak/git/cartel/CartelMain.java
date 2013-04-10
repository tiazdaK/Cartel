package au.tiazdak.git.cartel;

import org.bukkit.plugin.java.JavaPlugin;

import au.tiazdak.git.cartel.command.CommandManager;
import au.tiazdak.git.cartel.factory.CartelFactory;
import au.tiazdak.git.cartel.listener.BlockListener;
import au.tiazdak.git.cartel.listener.PlayerListener;
import au.tiazdak.git.cartel.util.Logger;

/*
 * Author: tiazdaK
 * Description: Cartel is a bukkit plugin which outlines an alternative 
 * 				way of team based player versus player combat.
 * Initial Commit: 01/04/2013
 */

public class CartelMain extends JavaPlugin {
	public enum RelationShip { thisCartel, enemyCartel, allyCartel, neutralCartel, noEntry };
	
	public CartelFactory cartelFactory = new CartelFactory();
	private Logger log = new Logger();
	
	
	@Override
	public void onEnable() {
		log.logInfo("Cartel has been enabled");
		
		//Create the cartel's file/populate it.
		cartelFactory.getCartelsOnDisc();
		cartelFactory.loadCartels();
		
		//Process/Load the configuration.
		this.saveDefaultConfig();
		this.reloadConfig();
		
		//Register Command Manager.
		getCommand("cartel").setExecutor(new CommandManager());
		//Register Listeners.
		new BlockListener(this);
		new PlayerListener(this);
	}

	@Override
	public void onDisable() {
		log.logInfo("Saving cartel data.");
		cartelFactory.writeCartelsToDisc();
		this.saveConfig();
		log.logInfo("Cartel has been disabled");
	}
}
