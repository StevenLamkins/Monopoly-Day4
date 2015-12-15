package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldHave40Squares() {

		// setup
		MonopolyGame game = new MonopolyGame();
		for (int i = 0; i < 4; i++) {
			game.addPlayer();
		}
		game.start();

		// verify
		List<Square> squares = game.getSquares();
		assertEquals(40, squares.size());
	}

	@Test
	public void shouldHaveCorrectNumberOfPlayers() {

		// setup
		MonopolyGame game = new MonopolyGame();
		for (int i = 0; i < 4; i++) {
			game.addPlayer();
		}
		
		game.start();
		int initNumPlayers = 4;

		int numPlayers = game.getNumberPlayers();
		assertEquals(initNumPlayers, numPlayers);
	}

	@Test
	public void shouldErrorWithTooManyPlayers() {

		MonopolyGame game = new MonopolyGame();

		try {
			for (int i = 0; i < 9; i++) {
				game.addPlayer();
			}
			game.start();
			fail();
		} catch (RuntimeException e) {
			assertTrue("Too Many Players", true);
		}
	}

	@Test
	public void shouldErrorWithTooFewPlayers() {

		MonopolyGame game = new MonopolyGame();
		try {
			game.addPlayer();
			game.start();
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Too Few Players", e.getMessage());
		}
	}

	@Test
	public void shouldStartPlayersOnGo() {

		MonopolyGame game = new MonopolyGame();
		for (int i = 0; i < 4; i++) {
			game.addPlayer();
		}
		game.start();
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			Square square = player.getSquare();

			assertEquals("Go", square.getName());
		}
	}
	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame();
		List<String> tokenList = new ArrayList<String>();
		for (int i = 0; i < MonopolyGame.MAX_NUM_PLAYERS; i++) {
			game.addPlayer();
			String token = game.getPlayers().get(i).getToken();
			
			if(tokenList.contains(token)) {
				fail();
			}
			tokenList.add(token);
		}
		assertTrue(true);
	}
	
	@Test
	public void shouldBeAbleToAddPlayer() {
		
		//Setup
		MonopolyGame game = new MonopolyGame();
		int currentNumPlayers = 0;
		game.addPlayer();		
		
		assertEquals(currentNumPlayers + 1, game.getNumberPlayers());
	}
	
}
