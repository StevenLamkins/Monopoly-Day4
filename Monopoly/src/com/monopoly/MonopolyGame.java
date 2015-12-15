package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {

	private Board board;
	
	private List<Player> players = new ArrayList<>();
	
	final int MAX_NUMBER_OF_PLAYERS = 8;

	public MonopolyGame() {
		board = new Board();
	}

	
	public List<Square> getSquares() {
		
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		for (int i = 2; i < MAX_NUMBER_OF_PLAYERS; i++) {
			Player player = new Player();
			players.add(player);
		}
		return players;
	}
	
	public Square getGoSquare () {
		
		return	board.getSquares().get(0);
	}

}
