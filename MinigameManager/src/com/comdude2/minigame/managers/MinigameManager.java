package com.comdude2.minigame.managers;

import org.bukkit.plugin.java.JavaPlugin;

import com.comdude2.minigames.games.Paintball;

public class MinigameManager extends JavaPlugin{
	
	protected CommandManager commandmanager;
	
	private MinigameController minicontroller;
	
	public void onEnable(){
		minicontroller = new MinigameController(this);
		commandmanager = new CommandManager();
		
		commandmanager.setup();
		getCommand("mm").setExecutor(commandmanager);
		
		getServer().getPluginManager().registerEvents(new Paintball(minicontroller), this);
		
	}
	
	public void onDisable(){
		
	}
	
}
