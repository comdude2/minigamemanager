package com.comdude2.minigame.commands;

import org.bukkit.entity.Player;

import com.comdude2.minigame.managers.MessageManager;
import com.comdude2.minigames.games.Paintball;

public class Test extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
		MessageManager.getInstance().good("Test", player, "This is a test message!");
		Paintball.setupPlayer(player);
	}

	@Override
	public String name() {
		return "Test";
	}

	@Override
	public String info() {
		return "A test command";
	}

	@Override
	public String[] aliases() {
		return new String[] {"t"};
	}

}
