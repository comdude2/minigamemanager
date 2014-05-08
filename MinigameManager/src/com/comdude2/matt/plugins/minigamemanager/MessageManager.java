package com.comdude2.matt.plugins.minigamemanager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageManager {
	
	private String name;

	private MessageManager() { }
	
	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
	}
	
	private String prefix = ChatColor.DARK_BLUE + "[" + ChatColor.DARK_RED + name + ChatColor.DARK_BLUE + "] ";
	
	public void info(String name, CommandSender s, String msg) {
		this.name = name;
		msg(s, ChatColor.YELLOW, msg);
	}
	
	public void error(String name, CommandSender s, String msg) {
		this.name = name;
		msg(s, ChatColor.RED, msg);
	}
	
	public void good(String name, CommandSender s, String msg) {
		this.name = name;
		msg(s, ChatColor.GREEN, msg);
	}
	
	private void msg(CommandSender s, ChatColor color, String msg) {
		s.sendMessage(prefix + color + msg);
	}
}