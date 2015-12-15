package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	List<Square> squares = new ArrayList<>();
	int numPlayers;

	List<Player> playerList = new ArrayList<>();
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int players) {
		if (players > 8) throw new IllegalArgumentException("Too many players!");
		if (players < 2) throw new IllegalArgumentException("Too few players!");
		
		this.numPlayers = players;
		for (int i = 0; i < 40; i++) {
			squares.add(new Square());
		}
		
		for (int indx = 0; indx < this.numPlayers; indx++) {
			
	       Player player = new Player();
	       playerList.add(player);
			
		}
		
	}
	
	public List<Square> getSquares() {
		return squares;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public List<String> getPlayers() {
		
		List<String> playerNames = new ArrayList<>();
		
		for (Player player : playerList) 
		{
			playerNames.add(player.getName());
		}
		
		return playerNames;
	}

	public int getPlayerLocation(String name) {
		

		for (Player player : playerList) 
		{
			if (player.getName().equals(name))
			{
				return player.getLocation();
			}
		}
		
		return -1;
	}

	
	
}
