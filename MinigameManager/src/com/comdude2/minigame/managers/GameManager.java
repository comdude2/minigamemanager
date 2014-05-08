package com.comdude2.minigame.managers;

import java.util.LinkedList;

import com.comdude2.minigame.main.Arena;
import com.comdude2.minigame.main.Game;

public class GameManager {

	private MinigameController minicontroller;
	private LinkedList <Game> games = new LinkedList <Game> ();
	
	public GameManager(MinigameController mminicontroller){
		minicontroller = mminicontroller;
	}
	
	public Arena getArena(Integer gameid){
		for (Game game : games){
			if (game.getID() == gameid){
				return minicontroller.arenamanager.getArena(game.getArenaID());
			}
		}
		return null;
	}
	
}
