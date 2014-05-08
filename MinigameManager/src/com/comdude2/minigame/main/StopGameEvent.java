package com.comdude2.minigame.main;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StopGameEvent extends Event{

	private static final HandlerList handlers = new HandlerList();
    private String minigame;
    private Integer gameid;
 
    public StopGameEvent(String mminigame, Integer mgameid) {
        minigame = mminigame;
        gameid = mgameid;
    }
 
    public String getEvent() {
        return minigame;
    }
    
    public Integer getGameID(){
    	return gameid;
    }
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
	
}
