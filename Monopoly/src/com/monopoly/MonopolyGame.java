package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	private static final int NUM_SQUARES = 40;
	private List<Square> squares = new ArrayList<>();
	
	public MonopolyGame() {
		for (int i = 1; i <= NUM_SQUARES; i++){
			squares.add(new Square());
		}
	}
	
	public List<Square> getSquares() {	
		return squares;
	}
// stuff

	public void setNumPlayers(int numPlayers) {
		// TODO Auto-generated method stub
		
	}

	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			players.add(new Player());
		}
		return players;
	}
}
