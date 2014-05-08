package com.comdude2.minigame.commands;

import org.bukkit.entity.Player;

public class Test extends SubCommand {

	@Override
	public void onCommand(Player p, String[] args) {
		System.out.println("Test Command called");
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
