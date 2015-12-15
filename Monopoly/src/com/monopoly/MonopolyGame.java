package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private int numberOfPlayers;
	
	private List<Player> players;
	private Board board;
	
	public MonopolyGame() {
		this.numberOfPlayers = 2;
		board = new Board();
		players = new ArrayList<>();
		placePlayersOnGo();
	}

	public MonopolyGame(int numberOfPlayers) {
		players = new ArrayList<>();
		this.numberOfPlayers = numberOfPlayers;
		placePlayersOnGo();
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
    public List<Square> getSquares() {
    	return board.getSquares();
    }
	
	private void placePlayersOnGo() {
		for (int i = 0; i < numberOfPlayers; i++) {
			Player aPlayer = new Player();
			aPlayer.setLocation(new Square("GO"));
			players.add(aPlayer);
		}
	}


}
