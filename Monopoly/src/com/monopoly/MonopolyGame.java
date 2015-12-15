package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	int numPlayers;
	private static final int MAX_NUM_PLAYERS = 8;
	private static final int MIN_NUM_PLAYERS = 2;
	List<Square> squares;

	public MonopolyGame(int numPlayers) {

		squares = new ArrayList<>();
		for (int i = 0; i < 40; i++) {

			squares.add(new Square());
		}
		
		this.numPlayers = numPlayers;
		if (numPlayers > MAX_NUM_PLAYERS) {
			throw new IllegalArgumentException("Too Many Players");
		} 
		if (numPlayers < MIN_NUM_PLAYERS) {
			throw new IllegalArgumentException("Too Few Players");
		}		
	}

	public List<Square> getSquares() {

		return this.squares;
	}

	public int getNumberPlayers() {
		return numPlayers;
	}

	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

}
