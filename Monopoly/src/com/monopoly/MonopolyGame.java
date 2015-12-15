package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private Board board;
	private List<Player> players = new ArrayList<Player>();
	public String[] tokens = new String[] {"dog", "wheelbarrow", "top hat", "thimble", "battleship", "car", "boot", "iron"};
	
	public MonopolyGame(int people){
		if (people < 2){
			throw new IllegalArgumentException("Too few players");
		}
		else if(people > 8){
			throw new IllegalArgumentException("Too many players");
		}
		board = new Board();
		Player person;
		for(int i=0; i < people; i++){
			person= new Player();
			person.setToken(tokens[i]);
			players.add(person);
			board.getSquares().get(0).addPlayertoSpace(person);
		}
		
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		return players;
	}
	

}
