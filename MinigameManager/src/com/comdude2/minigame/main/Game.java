package com.comdude2.minigame.main;

import java.util.LinkedList;
import java.util.UUID;

import com.comdude2.minigame.managers.MessageManager;

public class Game {

	private Integer gameid = 0;
	private Integer arenaid = 0;
	private LinkedList <UUID> players = new LinkedList <UUID> ();
	
	private static Game instance = new Game();
	
	public static Game getInstace() {
		return instance;
	}
	
	public Integer getID(){
		return gameid;
	}
	
	public Integer getArenaID(){
		return arenaid;
	}
	
	public LinkedList <UUID> getPlayers(){
		return players;
	}
	
	public void addPlayer(UUID uuid){
		if (!players.contains(uuid)){
			players.add(uuid);
		}
	}
	
	public void removePlayer(UUID uuid){
		if (players.contains(uuid)){
			players.remove(uuid);
		}
	}
	
}
