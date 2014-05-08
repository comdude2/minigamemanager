package com.comdude2.matt.plugins.minigamemanager;

import org.bukkit.plugin.Plugin;

public class MinigameController {

	protected Plugin plugin;
	protected CommandManager commandmanager;
	protected MessageManager messagemanager;
	
	public MinigameController(Plugin mplugin){
		plugin = mplugin;
		commandmanager = new CommandManager();
		messagemanager = new MessageManager();
	}
	
	public void ScheduleMinigame(String minigame, Long delay, Long repeat){
		
	}
	
}
