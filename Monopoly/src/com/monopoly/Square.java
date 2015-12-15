package com.monopoly;

import java.util.*;
public class Square {
	List<Player> playersOnSpace = new ArrayList<Player>();
	private String name;
	private int cost;
	private int rent;
	
	public void removePlayerFromSpace(Player p){
		playersOnSpace.remove(p);
	}
	
	public List<Player> getPlayersOnSpace() {
		return playersOnSpace;
	}

	public void setPlayersOnSpace(List<Player> playersOnSpace) {
		this.playersOnSpace = playersOnSpace;
	}

	public void addPlayertoSpace(Player p){
		playersOnSpace.add(p);
	}
	
}
