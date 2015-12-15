package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WhenSettingUpGame {
	/*
	 * @Before public void setUp() throws Exception { }
	 * 
	 * @After public void tearDown() throws Exception { }
	 */

	@Test
	public void shouldHave40Squares() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Square> squares = game.getSquares();

		// verify
		assertEquals(40, squares.size());
	}

	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Player> players = game.getPlayers();

		// verify
		assertTrue(players.size() >= 2 && players.size() <= 8);
	}

	@Test
	public void shouldErrorWithTooManyPlayers() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Player> players = game.getPlayers();

		// verify
		assertFalse(players.size() > 8);
	}

	@Test
	public void shouldErrorWithTooFewPlayers() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Player> players = game.getPlayers();

		// verify
		assertFalse(players.size() < 2);
	}

	@Test
	public void shouldStartPlayersOnGo() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Square> squares = game.getSquares();
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			Square square = player.getCurrentLocation();
			// verify
			assertEquals(squares.get(0), square);
		}
		}
	

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		fail("Not yet implemented");
	}
}
