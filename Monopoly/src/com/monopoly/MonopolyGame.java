package com.monopoly;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {

	private List<Player> players;
	private List<Square> squares;
	public enum Token{Dog, Thimble, Iron, Battleship, Wheelbarrow, Pen, Shoe, Tophat, Car};
	public MonopolyGame(int maxPlayers) {
		if(maxPlayers > 8)
		{
			throw new IllegalArgumentException("Too many players!");
		}
		if(maxPlayers < 2)
		{
			throw new IllegalArgumentException("Too few players!");
		}
		squares = new ArrayList<>();
		for(int i = 0; i < 40; i++){
			squares.add(new Square(i));		
		}


		players = new ArrayList<>();
		Iterator<Token> tokens = EnumSet.allOf(Token.class).iterator();
		for(int j = 0; j < maxPlayers && tokens.hasNext(); j++){
			players.add(new Player(squares.get(0), tokens.next()));
		}
	}

	public List<Square> getSquares() {
		return squares;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
