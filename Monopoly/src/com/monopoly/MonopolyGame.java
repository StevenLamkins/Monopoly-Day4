package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	Board board = new Board();
	List<Die> dice = new ArrayList<>();
	List<Player> playerList = new ArrayList<>();
	int numPlayers;
	String[] playerTokens = {"Dog", "Car", "Ship", "Boot", "Wheelbarrow", "Iron", "Thimble", "Hat"};
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int players) {
		if (players > 8) throw new IllegalArgumentException("Too many players!");
		if (players < 2) throw new IllegalArgumentException("Too few players!");
		
		this.numPlayers = players;
		
		for (int indx = 0; indx < this.numPlayers; indx++) {
	       Player player = new Player();
	       player.setToken(playerTokens[indx]);
	       playerList.add(player);
		}

		Die d1 = new Die();
		dice.add(d1);
		Die d2 = new Die();
		dice.add(d2);
		
	}
	
	public List<Square> getSquares() {
		return board.getSquares();
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public List<Player> getPlayers() {		
		return playerList;
	}

	public List<String> getPlayerNames() {
		
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

	public List<String> getPlayerTokens() {
		List<String> playerTokens = new ArrayList<>();
		
		for (Player player : playerList) 
		{
			playerTokens.add(player.getToken());
		}
		
		return playerTokens;
	}

	public List<Die> getDice() {
		return dice;
	}

	
	
}
