package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	private Board board;
	private List<Player> players;
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numPlayers) {
		if(numPlayers<2 || numPlayers>8) {
			throw new IllegalArgumentException("Incorrect number of players (2-8)");
		}

		board = new Board();
		players = new ArrayList<>();
		
		for (int i=0; i<numPlayers; i++) {
			players.add(new Player(i, 1500));
		}
	}

	
	public int getNumSquares() {
		return board.getNumSquares();
	}
	
	public int getNumPlayers() {
		return players.size();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public String getPlayerSquareName(Player p) {
		return board.getSquareAt(p.getPosition()).name();
	}
	
	public static void main(String args[]) {
		MonopolyGame game = new MonopolyGame();
	}
}
