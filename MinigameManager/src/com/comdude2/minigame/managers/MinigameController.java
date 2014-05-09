package com.comdude2.minigame.managers;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.plugin.Plugin;

import com.comdude2.minigame.main.Minigame;

public class MinigameController {

	protected Plugin plugin;
	protected MessageManager messagemanager;
	protected ArenaManager arenamanager;
	protected GameManager gamemanager;
	
	@SuppressWarnings("unused")
	private List <Minigame> minigames = new LinkedList <Minigame> ();
	
	public MinigameController(Plugin mplugin){
		plugin = mplugin;
		messagemanager = new MessageManager();
		arenamanager = new ArenaManager(this);
		gamemanager = new GameManager(this);
	}
	
	public void registerMinigame(Minigame minigame){
		
	}
	
	public GameManager getGameManager(){
		return gamemanager;
	}
	
	public ArenaManager getArenaManager(){
		return arenamanager;
	}
	
	public MessageManager getMessageManager(){
		return messagemanager;
	}
	
}
