package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {
	
	private int numberOfPlayers;
	
	private List<Player> players;
	private Board board;
	private Die dieOne;
	private Die dieTwo;
	
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
		dieOne = new Die();
		dieTwo = new Die();
		
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
			Player aPlayer = new Player();
			aPlayer.setLocation(board.getStartSquare());
			aPlayer.setMoney(1500);
			aPlayer.setToken(token);
			
			players.add(aPlayer);
		}
	}

	public List<Die> getDice() {
		List<Die> diceList = new ArrayList<>();
		diceList.add(dieOne);
		diceList.add(dieTwo);
		return diceList;
	}

	
	
}
