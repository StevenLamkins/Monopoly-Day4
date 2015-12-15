package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingupGames {
	
	private MonopolyGame game;
	
	@Before
	public void setup ()
	{
		game = new MonopolyGame(4);
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
		List<Player> players = game.getNumberOfPlayers();
		
		//verify
		assertTrue(players.size() > 1 && players.size() < 9);		
	}

	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		
		//setup + exercise
		List<Player> players = game.getNumberOfPlayers();
		
		//verify
		assertTrue(players.size() > 1 && players.size() < 9);			
	}
	
	@Ignore
	@Test
	public void shouldErrorWithTooFewPlayers() {
		
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void shouldStartyPlayerOnGo() {
		
		fail("Not yet implemented");
	}
	
	@Ignore	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		
		fail("Not yet implemented");
	}
	
	
	
}
