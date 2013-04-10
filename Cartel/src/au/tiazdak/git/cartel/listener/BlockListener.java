package au.tiazdak.git.cartel.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import au.tiazdak.git.cartel.CartelMain;
import au.tiazdak.git.cartel.util.Logger;

public class BlockListener implements Listener {
	private Logger log = new Logger();
	
    public BlockListener(CartelMain plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
		log.logInfo("Block Listener Active");
    }
    
    @EventHandler 
    public void onBlockBreak(BlockBreakEvent event) {
    	
    }

}
