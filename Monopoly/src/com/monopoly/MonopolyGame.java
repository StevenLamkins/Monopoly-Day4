package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 8;
	private static final int NUM_SQUARES = 40;
	private Square goSquare;
	private List<Square> squares = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	
	public MonopolyGame() {
		for (int i = 1; i <= NUM_SQUARES; i++){
			squares.add(new Square());
		}
		goSquare = squares.get(0);
		
		for (int i = 0; i < MIN_PLAYERS; i++) {
			players.add(new Player(Token.values()[i], goSquare));
		}
	}
	
	public List<Square> getSquares() {	
		return squares;
	}
// stuff

	public void setNumPlayers(int numPlayers) {
		if (numPlayers < MIN_PLAYERS) return;
		
		if (numPlayers > MAX_PLAYERS) numPlayers = MAX_PLAYERS;
		
		for (int i = MIN_PLAYERS; i < numPlayers; i++) {
			players.add(new Player(Token.values()[i], goSquare));
		}	
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void playRound() {
		
		
	}
}
