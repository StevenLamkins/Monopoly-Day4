package com.monopoly;

import java.util.List;


public class MonopolyGame
{
	private Board board;
	
	public MonopolyGame(int numPlayers)
	{
		board = new Board(numPlayers);
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
	
}
