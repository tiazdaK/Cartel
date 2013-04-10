package au.tiazdak.git.cartel.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import au.tiazdak.git.cartel.CartelMain;

public class CommandManager implements org.bukkit.command.CommandExecutor {
	//Gets commands from CartelMain and passes them to CommandExecutor.
	
	private CartelMain plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public CommandManager(CartelMain plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
		// implementation exactly as before...
	}
}
