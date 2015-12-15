package com.monopoly;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MonopolyGame
{
	private Board board;
	private Set<Player> players;
	
	public MonopolyGame(int numPlayers)
	{
		if(numPlayers > 8)
		{
			throw new IllegalArgumentException("Too many players");
		}
		else if(numPlayers < 2)
		{
			throw new IllegalArgumentException("Too few players");
		}
		board = new Board(numPlayers);
		players = new HashSet<>();
		
		for (int i = 0; i < numPlayers; i++)
		{
			players.add(new Player());
		}
	}
	
	public List<Square> getSquares()
	{
		return board.getSquares();
	}
	public int roll()
	{
		Die die = new Die();
		return die.roll() + die.roll();
	}
	
	public Set<Player> getPlayers()
	{
		return players;
	}
	
}
