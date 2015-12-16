package com.monopoly;

import java.util.ArrayList;
import java.util.List;


public class MonopolyGame
{
	private Board board;
	private List<Player> players;
	
	
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
		
		board = new Board();
		players = new ArrayList<>();
		
		for (int i = 0; i < numPlayers; i++)
		{
			players.add(new Player(i, board.getStartSquare()));
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
	
	public List<Player> getPlayers()
	{
		return players;
	}
	
}
