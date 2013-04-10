package au.tiazdak.git.cartel.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import au.tiazdak.git.cartel.util.Logger;
import au.tiazdak.git.cartel.util.Reply;

public class CommandManager implements org.bukkit.command.CommandExecutor {
	//Gets commands from CartelMain and passes them to CommandExecutor.
	private Logger log = new Logger();
	private Reply reply = new Reply();
	
	public CommandManager() {
		log.logInfo("Command Manager Active");
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			return isPlayer((Player) sender, cmd, label, args);
		} else {
			return isServer(sender, cmd, label, args);
		}
	}
		
	public boolean isPlayer(Player sender, Command cmd, String label, String[] args) {
		switch(label) {
			case "create":
				if(args.length == 1) {
		
					return true;
				} else {
					incorrectLength(sender, 1);
				}
				break;
			case "disband":
				if(args.length == 0) {
		
					return true;
				}
				break;
			case "join":
				if(args.length == 1) {
		
					return true;
				} else {
					incorrectLength(sender, 1);
				}
				break;
			case "invite":
				if(args.length == 1) {
					
					return true;
				} else {
					incorrectLength(sender, 1);
				}
				break;		
		}
		return true;
		
	}
	
	public boolean isServer(CommandSender sender, Command cmd, String label, String[] args) {
		log.logInfo("Server Commands not implemented");
		return true;
	}
	
	public void incorrectLength(Player sender, int correctLength) {
		reply.replyError("Incorrect arguement length, " + correctLength + " is the required amount.", sender);		
	}
}
