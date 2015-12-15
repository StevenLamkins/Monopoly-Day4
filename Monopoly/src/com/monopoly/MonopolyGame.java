package com.monopoly;

import java.util.ArrayList;
import java.util.List;


public class MonopolyGame
{
	List<Square> squares;
	private int numPlayers;
	
//	public MonopolyGame()
//	{
//		squares = new ArrayList<>();
//		for (int i =0; i < 40; i++)
//		{
//			Square temp = new Square();
//			squares.add(temp);
//		}
//
//	}
	
	public MonopolyGame(int numPlayers)
	{
		squares = new ArrayList<>();
		for (int i =0; i < 40; i++)
		{
			Square temp = new Square();
			squares.add(temp);
		}
		this.numPlayers = numPlayers;
		
	}
	
	public List<Square> getSquares()
	{
		return squares;
	}
	public int roll()
	{
		Die die = new Die();
		return die.roll() + die.roll();
	}
	
}
