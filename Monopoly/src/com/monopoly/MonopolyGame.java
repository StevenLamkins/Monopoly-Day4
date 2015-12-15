package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private int numberOfPlayers;
	
	private List<Player> players;
	private Board board;
	private Die dieOne;
	private Die dieTwo;
	
	public MonopolyGame() {
		this.numberOfPlayers = 2;
		board = new Board();
		players = new ArrayList<>();
		setupPlayers();
		dieOne = new Die();
		dieTwo = new Die();
		
	}

	public MonopolyGame(int numberOfPlayers) {
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
			Player aPlayer = new Player();
			aPlayer.setLocation(new Square("GO"));
			aPlayer.setMoney(1500);
			
			players.add(aPlayer);
		}
		Player[] playerList = new Player[players.size()];
		players.toArray(playerList);
		
		int i = 0;
		for (Token aToken : Token.values()) {
			playerList[i++].setToken(aToken);
			if (i == players.size())
				break;
		}
	}

	public List<Die> getDice() {
		List<Die> diceList = new ArrayList<>();
		diceList.add(dieOne);
		diceList.add(dieTwo);
		return diceList;
	}

	
	
}
