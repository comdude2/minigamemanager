package com.comdude2.matt.plugins.minigamemanager;

public class Arena {

	private String name;
	private String minigame;
	private boolean inUse;
	
	public Arena(String mname, String mminigame){
		name = mname;
		minigame = mminigame;
		inUse = false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMinigame(){
		return minigame;
	}
	
	public boolean inUse(){
		return inUse;
	}
	
}
