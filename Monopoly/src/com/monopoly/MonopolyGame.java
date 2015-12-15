package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private int numberOfPlayers;
	private List<Square> squares;
	private List<Player> players;
	
	public MonopolyGame() {
		this.numberOfPlayers = 2;
		createSquares();
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
	
	public List<Square> getSquares() {
		return squares;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	private void placePlayersOnGo() {
		for (int i = 0; i < numberOfPlayers; i++) {
			Player aPlayer = new Player();
			aPlayer.setLocation(new Square("GO"));
			players.add(aPlayer);
		}
	}
	
	private void createSquares() {
		squares = new ArrayList<>();
	   for (int i = 0; i < 40; i++) {
			squares.add(new Square(""));
		}
	}

}
