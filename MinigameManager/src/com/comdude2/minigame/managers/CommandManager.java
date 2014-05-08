package com.comdude2.minigame.managers;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.comdude2.minigame.commands.SubCommand;
import com.comdude2.minigame.commands.Test;



public class CommandManager implements CommandExecutor{

private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	
	public void setup() {
		commands.add(new Test());
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			MessageManager.getInstance().error("Minigame", sender, "Only players can use minigame");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("mm")) {
			if (args.length == 0) {
				for (SubCommand c : commands) {
					MessageManager.getInstance().info("Minigame", player, "/snowfight " + c.name() + " - " + c.info());
				}
				return true;
			}
			
			SubCommand target = get(args[0]);
			
			if (target == null) {
				MessageManager.getInstance().error("Minigame", player, "/snowfight " + args[0] + " is not a valid subcommand!");
				return true;
			}
			
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = a.toArray(new String[a.size()]);
			
			try {
				target.onCommand(player, args);
			}
			
			catch (Exception e) {
				MessageManager.getInstance().error("Minigame", player, "An error has occured: " + e.getCause());
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	private String aliases(SubCommand cmd) {
		String fin = "";
		
		for (String a : cmd.aliases()) {
			fin += a + " | ";
		}
		
		return fin.substring(0, fin.lastIndexOf(" | "));
	}
	
	private SubCommand get(String name) {
		for (SubCommand cmd : commands) {
			if (cmd.name().equalsIgnoreCase(name)) return cmd;
			for (String alias : cmd.aliases()) if (name.equalsIgnoreCase(alias)) return cmd;
		}
		return null;
	}

}
