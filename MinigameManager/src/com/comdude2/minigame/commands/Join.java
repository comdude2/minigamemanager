package com.comdude2.minigame.commands;

import org.bukkit.entity.Player;
import com.comdude2.minigame.managers.MenuManager;

public class Join extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
		if(args.length == 1) {
			player.openInventory(MenuManager.getInstance().getInventory());
		}
	}

	@Override
	public String name() {
		return "join";
	}

	@Override
	public String info() {
		return "Join a minigame";
	}

	@Override
	public String[] aliases() {
		return new String[] {"j"};
	}
}
