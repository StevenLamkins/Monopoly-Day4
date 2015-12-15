package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private List<Square> squares = new ArrayList<Square>();
	private List<Player> players = new ArrayList<Player>();
	private String[] tokens = new String[] {"dog", "wheelbarrow", "top hat", "thimble", "battleship", "car", "boat", "iron"};
	
	public MonopolyGame(int people){
		if (people < 2){
			throw new IllegalArgumentException("Too few players");
		}
		else if(people > 8){
			throw new IllegalArgumentException("Too many players");
		}
		
		int count = 0;
		Square property = new Square();
		while(count < 40){
			squares.add(property);
			count++;
		}
		count = 0;
		Player person;
		while(count < people){
			person= new Player();
			person.setToken(tokens[count]);
			players.add(person);
			squares.get(0).addPlayertoSpace(person);
			count++;
		}
		
	}

	public List<Square> getSquares() {
		return squares;
	}

	public List<Player> getPlayers() {
		return players;
	}
	

}
