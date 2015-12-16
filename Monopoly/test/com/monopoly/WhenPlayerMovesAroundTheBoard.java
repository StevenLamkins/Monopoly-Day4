package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenPlayerMovesAroundTheBoard {

	@Test
	public void playerShouldMoveCorrectNumberOfSquares() 
	{
		
		for (int x = 2; x < 9; x++) {
			MonopolyGame game = new MonopolyGame(x);
			List<Player> players = game.getPlayers();
			List<Square> squares = game.getSquares();
			Player testPlayer = players.get(x-1);
			Square expectedSquare;
			
			
			testPlayer.move(45);
			expectedSquare = squares.get(5);
			assertEquals(expectedSquare, testPlayer.getCurrentPosition());

		}
		
	}
	
	
	@Test
	public void playerCirclesBoard() 
	{
		MonopolyGame game = new MonopolyGame(2);
		Player testPlayer = game.getPlayers().get(0);
		
		Square expectedSquare = game.getSquares().get(5);
		testPlayer.move(45);
		
		assertEquals(expectedSquare,testPlayer.getCurrentPosition());
		
	}
	
	@Test
	public void playerLeavesGo()
	{
		MonopolyGame game = new MonopolyGame(2);
		Player testPlayer = game.getPlayers().get(0);
		
		Square expectedSquare = game.getSquares().get(1);
		testPlayer.move(1);
		
		assertEquals(expectedSquare,testPlayer.getCurrentPosition());
	}
	
	
	@Test
	public void playerTakesTurn()
	{
		MonopolyGame game = new MonopolyGame(2);
		 game.playRound();
				
		assertEquals(expectedSquare,testPlayer.getCurrentPosition());
	}
	

}
