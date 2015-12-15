package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	private List<Square> squares = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private Board board;
	private int[] location; 
	private Player player;
	
	private final int MIN_NUMBER_PLAYERS = 2;
	private final int MAX_NUMBER_PLAYERS = 8;
	
	public MonopolyGame()
	{
		
	}
	
	public MonopolyGame(int numberOfPlayers) {
		
		if(numberOfPlayers >= MIN_NUMBER_PLAYERS && numberOfPlayers <= MAX_NUMBER_PLAYERS)
		{
			for (int i = 0; i < numberOfPlayers; i++)
			{
				player = new Player();
				players.add(player);
			}
		}
		else if(numberOfPlayers > MAX_NUMBER_PLAYERS || numberOfPlayers < MIN_NUMBER_PLAYERS) 
		{
			throw new IllegalArgumentException("Too many players");  
		}
	
	}
	
	public List<Square> getSquares() {
		// TODO Auto-generated method stub
		board = new Board();
		squares = board.getSquares();
		
		
		return squares;
	}

	public List<Player> getNumberOfPlayers() {
		
		
		return players;
	}

	public int[] getPlayerLocation(int numberOfPlayers) {
		location = new int[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++)
		{
			location[i] = player.getLocation();
		}
		
		return location;
	}
	
	
	
	
	
}
