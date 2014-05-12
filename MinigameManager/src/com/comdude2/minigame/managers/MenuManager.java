package com.comdude2.minigame.managers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.comdude2.minigame.commands.MenuItem;

public class MenuManager {

	private Inventory menu;
	private ArrayList<MenuItem> menuItems;
	
	private static MenuManager instance = new MenuManager();
	
	public static MenuManager getInstance() {
		return instance;
	}
	
	public void setupMenu() {
		menu = Bukkit.createInventory(null, 9, "Minigame Menu");
		menuItems = new ArrayList<MenuItem>();
		
		menuItems.add(new MenuItem("Paint Ball", ChatColor.RED, "Shoot with a paintball gun", Material.SNOW_BALL));
		menuItems.add(new MenuItem("Spleef", ChatColor.RED, "Add description here", Material.DIAMOND_SPADE));
		
		for(int i = 0; i < menuItems.size(); i++) {
			ItemStack itemStack = new ItemStack(menuItems.get(i).item);
			ItemMeta itemMeta = itemStack.getItemMeta();
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + menuItems.get(i).description);
			itemMeta.setDisplayName(menuItems.get(i).nameColor + menuItems.get(i).name);
			itemMeta.setLore(lore);
			itemStack.setItemMeta(itemMeta);
			
			menu.addItem(itemStack);
		}
	}
	
	public void openMenu(Player player) {
		player.openInventory(menu);
	}
	
	public Inventory getInventory() {
		return menu;
	}
}
