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
	       player.setLocation(board.getSquares().get(0));
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

	public List<Die> getDice() {
		return dice;
	}

	
	
}
