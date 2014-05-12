package com.comdude2.minigame.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public class MenuItem {

	public String name;
	public ChatColor nameColor;
	public String description;
	public Material item;
	
	public MenuItem(String name, ChatColor nameColor, String description, Material item) {
		this.name = name;
		this.nameColor = nameColor;
		this.description = description;
		this.item = item;
	}
}


