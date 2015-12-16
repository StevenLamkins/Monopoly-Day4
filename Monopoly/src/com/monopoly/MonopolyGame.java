package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {
	
	private Board board;
	private List<Player> players = new ArrayList<Player>();
	public String[] tokens = new String[] {"dog", "wheelbarrow", "top hat", "thimble", "battleship", "car", "boot", "iron"};
	private Die die1;
	private Die die2;
	
	public MonopolyGame(int people){
		if (people < 2){
			throw new IllegalArgumentException("Too few players");
		}
		else if(people > 8){
			throw new IllegalArgumentException("Too many players");
		}
		board = new Board();
		die1 = new Die();
		die2 = new Die();
		Player person;
		for(int i=0; i < people; i++){
			person= new Player(board.getSquares().get(0));
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

	public void playRound() {
		for(Player player : players){
			player.takeTurn(die1, die2);
		}
		
	}
	

}
