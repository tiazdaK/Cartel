package au.tiazdak.git.cartel.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CartelCreateEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private String message;
 
    public CartelCreateEvent(String example) {
        message = example;
    }
 
    public String getMessage() {
        return message;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }


}
