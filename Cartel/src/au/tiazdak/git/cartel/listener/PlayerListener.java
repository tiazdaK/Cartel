package au.tiazdak.git.cartel.listener;

import org.bukkit.event.Listener;

import au.tiazdak.git.cartel.CartelMain;
import au.tiazdak.git.cartel.util.Logger;

public class PlayerListener implements Listener {
	private Logger log = new Logger();
	
    public PlayerListener(CartelMain plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
		log.logInfo("Player Listener Active");
    }
    
}
