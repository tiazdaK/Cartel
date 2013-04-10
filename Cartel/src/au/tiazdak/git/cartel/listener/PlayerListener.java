package au.tiazdak.git.cartel.listener;

import org.bukkit.event.Listener;

import au.tiazdak.git.cartel.CartelMain;

public class PlayerListener implements Listener {
    public PlayerListener(CartelMain plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
}
