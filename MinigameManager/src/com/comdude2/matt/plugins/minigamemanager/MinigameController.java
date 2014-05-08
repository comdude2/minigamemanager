package com.comdude2.matt.plugins.minigamemanager;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.plugin.Plugin;

public class MinigameController {

	protected Plugin plugin;
	protected CommandManager commandmanager;
	protected MessageManager messagemanager;
	@SuppressWarnings("unused")
	private List <Minigame> minigames = new LinkedList <Minigame> ();
	
	public MinigameController(Plugin mplugin){
		plugin = mplugin;
		commandmanager = new CommandManager();
		messagemanager = new MessageManager();
	}
	
	public void registerMinigame(Minigame minigame){
		
	}
	
}
