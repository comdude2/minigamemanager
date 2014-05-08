package com.comdude2.matt.plugins.minigamemanager;

import org.bukkit.plugin.java.JavaPlugin;

public class MinigameManager extends JavaPlugin{
	
	//Private and not protected to prevent unauthorised usage (stops outside plugins interfacing)
	@SuppressWarnings("unused")
	private MinigameController minicontroller;
	
	public void onEnable(){
		minicontroller = new MinigameController(this);
	}
	
	public void onDisable(){
		
	}
	
}
