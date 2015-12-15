package com.monopoly;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dicegame.Die;

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
		MonopolyGame game = new MonopolyGame(5);
		// verify
		assertEquals(5, game.getPlayers().size());
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithTooManyPlayers() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame(9);
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorWithTooFewPlayers() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame(1);
		
	}

	@Test
	public void shouldStartPlayersOnGo() {
		// setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Square> squares = game.getSquares();
		List<Player> players = game.getPlayers();

		for (Player player : players) {
			Square currentSquare = player.getCurrentSquare();
			assertEquals(currentSquare, squares.get(0));
			Die die;
		}
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame();
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			assertNotNull(player.getToken());
		}
	}
}
