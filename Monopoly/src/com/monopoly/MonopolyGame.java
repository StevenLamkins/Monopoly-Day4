package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die;

public class MonopolyGame {
	private List<Square> squares = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private List<Die> dice = new ArrayList<>();
	private Board board;
	private int[] location; 
	private Player player;
	private int dieRoll;
	private boolean flag;
	
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

	public void playRound() {
		dice.add(new Die());
		dice.add(new Die());
		for (Player player : players) {
			dieRoll = 0;
			for (Die die : dice) {
				dieRoll += die.rollDie(); 
			}		
			
			player.move(dieRoll);
		}
	}

	public boolean verifyMovement() {
		// TODO Auto-generated method stub
		for (Player  player : players) {
			flag = player.verifyMovement(dieRoll);
		}
		return flag;
	}
	
	
	
	
	
}
