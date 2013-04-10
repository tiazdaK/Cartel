package au.tiazdak.git.cartel.util;

import org.bukkit.Server;
import org.bukkit.entity.Player;

public class Reply {
	
	public Reply() {
		
	}
	
	public void replyInfo(String message, Player p) {
		p.sendMessage(message + ".");		
	}
	
	public void replyError(String message, Player p) {
		p.sendMessage("&c" + message + ".");		
	}
	
	public void replyPermError(String Permission, Player p) {
		p.sendMessage("You do not have the permissions " + Permission + ".");
	}
}
