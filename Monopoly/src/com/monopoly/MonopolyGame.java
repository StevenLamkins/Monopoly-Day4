package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	
	private List<Square> squares = new ArrayList<Square>();
	private List<Player> players = new ArrayList<Player>();
	
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
		Player person = new Player();
		while(count < people){
			players.add(person);
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
