package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {

	private List<Square> squares = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	
	final int NUMBER_OF_SQUARES = 40;
	final int MAX_NUMBER_OF_PLAYERS = 8;

	public MonopolyGame() {
		for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
			squares.add(new Square());
		}
	}

	
	public List<Square> getSquares() {
		
		return squares;
	}

	public List<Player> getPlayers() {
		for (int i = 2; i < MAX_NUMBER_OF_PLAYERS; i++) {
			Player player = new Player();
			players.add(player);
		}
		return players;
	}

}
