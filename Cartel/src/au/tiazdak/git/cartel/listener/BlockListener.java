package au.tiazdak.git.cartel.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import au.tiazdak.git.cartel.CartelMain;

public class BlockListener implements Listener {
    public BlockListener(CartelMain plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler 
    public void onBlockBreak(BlockBreakEvent event) {
    	
    }

}
