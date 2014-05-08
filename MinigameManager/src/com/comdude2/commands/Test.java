package com.comdude2.commands;

import org.bukkit.entity.Player;

import com.avaje.ebeaninternal.server.cluster.mcast.Message;
import com.comdude2.minigame.managers.MessageManager;

public class Test extends SubCommand {

	@Override
	public void onCommand(Player p, String[] args) {
		MessageManager.getInstance().good("Test", p, "The command manager is working");
		
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
