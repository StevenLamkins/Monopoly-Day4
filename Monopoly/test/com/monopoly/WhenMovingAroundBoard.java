package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingAroundBoard {
	private MonopolyGame game;
	private final int NUM_OF_PLAYERS = 4;
	private List<Player> players;
	
	@Before
	public void setup ()
	{
		game = new MonopolyGame(NUM_OF_PLAYERS);
		players = game.getNumberOfPlayers();
		game.playRound();
	}
	
	@Ignore
	@Test
	public void allPlayersLeaveGoSquare() {
		int [] location = game.getPlayerLocation(NUM_OF_PLAYERS);
		for(int i = 0; i < NUM_OF_PLAYERS; i++)
		{
			if(location[i] == 0)
			{
				fail("Piece didn't move");
			}			
		}	
	}
	
//	@Ignore 
	@Test
	public void playerMovesCorrectNumberOfSquares() {
		boolean flag;
		flag = game.verifyMovement();
		assertTrue(flag = true);
		
	}
	
	@Ignore
	@Test
	public void playerCirclesTheBoard() {
		fail("Not yet implemented");
	}
	
}
