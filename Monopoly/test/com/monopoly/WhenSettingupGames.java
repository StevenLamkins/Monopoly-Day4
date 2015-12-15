package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingupGames {
	
	private MonopolyGame game;
	private final int NUM_OF_PLAYERS = 4;
	private List<Player> players;
	
	@Before
	public void setup ()
	{
		game = new MonopolyGame(NUM_OF_PLAYERS);
		players = game.getNumberOfPlayers();
	}
	@Ignore
	@Test
	public void shouldHave40Squares() {
		// setup + exercise
		List<Square> squares = game.getSquares();
		
		// verify
		assertEquals(40, squares.size());
	}
	
	@Ignore
	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		
		//setup + exercise
	//	List<Player> players = game.getNumberOfPlayers();
		
		//verify
		assertTrue(players.size() > 1 && players.size() < 9);		
	}

	@Ignore
	@Test
	public void shouldErrorWithTooManyPlayers() {
		
		try{
			//setup + exercise
			game = new MonopolyGame(12);
			List<Player> players = game.getNumberOfPlayers();
			fail();
		}
		catch(IllegalArgumentException ex)
		{
			assertNotEquals(null, ex);
		}
	}
	
	@Ignore
	@Test
	public void shouldErrorWithTooFewPlayers() {
		try{
			//setup + exercise
			game = new MonopolyGame(1);
			List<Player> players = game.getNumberOfPlayers();
			fail();
		}
		catch(IllegalArgumentException ex)
		{
			assertNotEquals(null, ex);
		}
	}
	
	
	@Ignore
	@Test
	public void shouldStartPlayerOnGo() {
		
		int [] location = game.getPlayerLocation(NUM_OF_PLAYERS);
		for(int i = 0; i < NUM_OF_PLAYERS; i++)
		{
			if(location[i] != 0)
			{
				fail("Location is not on Go");
			}			
		}	
	}
	
//	@Ignore	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		
		fail("Not yet implemented");
	}
	
	@Ignore	
	@Test
	public void nameOfSquares() {
		
		fail("Not yet implemented");
	}
	
	@Ignore	
	@Test
	public void shouldHaveUniqueNamesForSquares() {
		MonopolyGame game = new MonopolyGame(2);
		List<Square> squaers = game.getSquares();
		assertEquals("Go Square", squares.get(0).getName());
//		fail("Not yet implemented");
	}
}
