package au.tiazdak.git.cartel.util;

import au.tiazdak.git.cartel.CartelMain;

public class Logger {
	//Logger for Cartel, formats messages to be easily readable in console.

	private CartelMain cm = new CartelMain();
	private java.util.logging.Logger log = cm.getLogger();
	
	public void logInfo(String message) {
		log.info(message);
	}
	
	public void logInfo(String message, String extra) {
		log.info(message);
		log.info(extra);
	}
	
	public void logWarning(String message) {
		log.warning(message);
	}
	
	public void logWarning(String message, String extra) {
		log.warning(message);
		log.warning(extra);
	}
	
	public void logSevere(String message) {
		log.severe(message);
	}
	
	public void logSevere(String message, String extra) {
		log.severe(message);
		log.severe(extra);
	}	
}
