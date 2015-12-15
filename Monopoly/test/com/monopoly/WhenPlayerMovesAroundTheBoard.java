package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPlayerMovesAroundTheBoard {


	@Test
	public void playerShouldMoveCorrectNumberOfSquares() {
		
		for (int x = 2; x < 9; x++) {
			MonopolyGame game = new MonopolyGame(x);
			List<Player> players = game.getPlayers();
			List<Square> squares = game.getSquares();
			Player testPlayer = players.get(x-1);
			
			fail("NEED TO FIX");
			testPlayer.move(49);
			Square expectedSquare = squares.get(9);
			assertEquals(expectedSquare,
			testPlayer.getCurrentPosition());
				
			
		}
		
	}
	
	
	@Test
	public void playerCirclesBoard() 
	{
		MonopolyGame game = new MonopolyGame(2);
		Player testPlayer = game.getPlayers().get(0);
		
		Square expectedSquare = game.getSquares().get(5);
		testPlayer.move(5);
		
		assertEquals(expectedSquare,testPlayer.getCurrentPosition());
		
	}
	
	@Ignore
	@Test
	public void playerLavesGo(){
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void playerRollsSameAsMovement(){
		fail("Not yet implemented");
	}
}
