package au.tiazdak.git.cartel.util;

import au.tiazdak.git.cartel.CartelMain;

public class Permission {
	//Easy permission checking against the registered list.
	private CartelMain cm = new CartelMain();
	
	private String[] Permissions = {"cartel.join", "cartel.invite", "cartel.kick",
									"cartel.kick.other", "cartel.leave", "cartel.create",
									"cartel.disband", "cartel.disband.other", "cartel.info",
									"cartel.info.general", "cartel.info.other", "cartel.promote",
									"cartel.promote.other", "cartel.use"};
	
	public boolean checkServerPermission(String player, String permission) {
		//Checks against all registered permissions
		switch(permission) {
			case "join":
				if(doesPlayerHavePermission(player, Permissions[0])) 
					return true;
				else
					break;
			case "invite":
				if(doesPlayerHavePermission(player, Permissions[1])) 
					return true;
				else
					break;
			case "kick":
				if(doesPlayerHavePermission(player, Permissions[2])) 
					return true;
				else
					break;
			case "kick-other":
				if(doesPlayerHavePermission(player, Permissions[3])) 
					return true;
				else
					break;
			case "leave":
				if(doesPlayerHavePermission(player, Permissions[4])) 
					return true;
				else
					break;
			case "create":
				if(doesPlayerHavePermission(player, Permissions[5])) 
					return true;
				else
					break;
			case "disband":
				if(doesPlayerHavePermission(player, Permissions[6])) 
					return true;
				else
					break;
			case "disband-other":
				if(doesPlayerHavePermission(player, Permissions[7])) 
					return true;
				else
					break;
			case "info":
				if(doesPlayerHavePermission(player, Permissions[8])) 
					return true;
				else
					break;
			case "info-general":
				if(doesPlayerHavePermission(player, Permissions[9])) 
					return true;
				else
					break;
			case "info-other":
				if(doesPlayerHavePermission(player, Permissions[10])) 
					return true;
				else
					break;
			case "promote":
				if(doesPlayerHavePermission(player, Permissions[11])) 
					return true;
				else
					break;
			case "promote-other":
				if(doesPlayerHavePermission(player, Permissions[12])) 
					return true;
				else
					break;
			case "use":
				if(doesPlayerHavePermission(player, Permissions[13])) 
					return true;
				else
					break;		
		}
		return false;		
	}	
	
	private boolean doesPlayerHavePermission(String player, String permission) {
		if(cm.getServer().getPlayerExact(player).hasPermission(permission)) {
			return true;
		}
		return false;
	}
}
