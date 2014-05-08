package com.comdude2.minigame.managers;

import java.util.LinkedList;
import java.util.List;

import com.comdude2.minigame.main.Arena;

public class ArenaManager {

	private MinigameController minicontroller;
	private List <Arena> arenas = new LinkedList <Arena> ();
	
	public ArenaManager(MinigameController mminicontroller){
		minicontroller = mminicontroller;
	}
	
	public Arena getArena(Integer arenaid){
		return null;
	}
	
}
