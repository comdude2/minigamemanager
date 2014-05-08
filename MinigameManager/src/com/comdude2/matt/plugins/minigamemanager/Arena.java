package com.comdude2.matt.plugins.minigamemanager;

public class Arena {

	private String name;
	private String event;
	private boolean inUse;
	
	public Arena(String mname, String mevent){
		name = mname;
		event = mevent;
		inUse = false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEvent(){
		return event;
	}
	
	public boolean inUse(){
		return inUse;
	}
	
}
