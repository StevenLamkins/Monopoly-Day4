package com.monopoly;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class MonopolyGame {

	private List<Player> players = new ArrayList<>();
	private List<Die> dice = new ArrayList<>();
	private Board board  = new Board();

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

		dice.add(new Die(14561));
		dice.add(new Die(123048));

		Iterator<Token> tokens = EnumSet.allOf(Token.class).iterator();
		for(int j = 0; j < maxPlayers && tokens.hasNext(); j++){
			players.add(new Player(board.getSquares().get(0), tokens.next(), dice));
		}
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public List<Die> getDice() {
		return dice;
	}
}
