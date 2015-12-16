package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {
	
	private int numberOfPlayers;
	
	private List<Player> players;
	private Board board;
	private Die aDie;
	
	public Die getaDie() {
		return aDie;
	}

	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numberOfPlayers) {
		if (numberOfPlayers > 8) throw new IllegalArgumentException();
		if (numberOfPlayers < 2) throw new IllegalArgumentException();
		players = new ArrayList<>();
		board = new Board();
		this.numberOfPlayers = numberOfPlayers;
		setupPlayers();
		aDie= new Die();
		//board.printBoard();
		
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
	
	private void setupPlayers() {
		for (int i = 0; i < numberOfPlayers; i++) {
			Token token = Token.values()[i];
			Player aPlayer = new Player(board.getStartSquare(), token);
			players.add(aPlayer);
		}
	}

	public void playRound() {
		for (Player player : players) {
			player.takeTurn(aDie);
		}
	}
	
	
}
