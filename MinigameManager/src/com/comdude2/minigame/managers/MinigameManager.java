package com.comdude2.minigame.managers;

import org.bukkit.plugin.java.JavaPlugin;

import com.comdude2.minigame.main.MinigameController;

public class MinigameManager extends JavaPlugin{
	
	protected CommandManager commandmanager;
	
	//Private and not protected to prevent unauthorized usage (stops outside plugins interfacing)
	@SuppressWarnings("unused")
	private MinigameController minicontroller;
	
	public void onEnable(){
		minicontroller = new MinigameController(this);
		commandmanager = new CommandManager();
		
		commandmanager.setup();
		getCommand("mm").setExecutor(commandmanager);
		
	}
	
	public void onDisable(){
		
	}
	
}
