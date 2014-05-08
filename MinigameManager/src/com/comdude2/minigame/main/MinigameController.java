package com.comdude2.minigame.main;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.plugin.Plugin;

import com.comdude2.minigame.managers.CommandManager;
import com.comdude2.minigame.managers.MessageManager;

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
