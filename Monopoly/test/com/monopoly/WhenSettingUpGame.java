package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {
	private MonopolyGame game;
	private int initNumPlayers = 4;

	@Before
	public void setUp() throws Exception {
		//setup
		game = new MonopolyGame(initNumPlayers);
	}

	@Test
	public void shouldHave40Squares() {		
		//verify
		List<Square> squares = game.getSquares();
		
		assertEquals(40, squares.size());		

	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		int numPlayers = game.getNumberPlayers();
		assertEquals(initNumPlayers, numPlayers);
	}

	@Test
	public void shouldErrorWithTooManyPlayers() {
		
		try {
			game = new MonopolyGame(9);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue("Too Many Players", true);

		}
	}	
	
	@Test
	public void shouldErrorWithTooFewPlayers() {
		try {
			game = new MonopolyGame(0);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Too Few Players", e.getMessage());
		}
	}
	
	@Test
	public void shouldStartPlayersOnGo() {
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			Square square = player.getSquare();
			
			assertEquals(square.getName(), "Go");
			
		} 
		

	}
	
	@Ignore
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		fail("Not yet implemented");
	}
	
}
