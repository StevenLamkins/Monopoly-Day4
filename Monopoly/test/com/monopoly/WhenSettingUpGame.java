package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {
	
	public final static int FIRST_LOCATION = 0;

	@Test
	public void shouldHave40Squares() {
		// setup and exercise
		MonopolyGame game = new MonopolyGame();
		List<Square> squares = game.getSquares();
		
		// verify
		assertEquals(40, squares.size());
	}

	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		// setup and exercise
		Random randomGenerator = new Random();
		int numPlayers = randomGenerator.nextInt(7) + 2;
		MonopolyGame game = new MonopolyGame(numPlayers);
		
		// verify
		assertEquals(numPlayers, game.getNumPlayers());
	}

	@Test
	public void shouldErrorWithTooManyPlayers() {
		try{
			MonopolyGame game = new MonopolyGame(10);
			fail();
			
		}catch(IllegalArgumentException e) {
			assertEquals("Too many players!", e.getMessage());
		}
	}

	@Test
	public void shouldErrorWithTooFewPlayers() {
		try{
			MonopolyGame game = new MonopolyGame(0);
			fail();
			
		}catch(IllegalArgumentException e) {
			assertEquals("Too few players!", e.getMessage());
		}
	}

	@Test
	public void shouldStartPlayersOnGo() {
		MonopolyGame game = new MonopolyGame();
		List<String> players = game.getPlayers();
		
		for (String name : players) {
			int location = game.getPlayerLocation(name);
			assertEquals(FIRST_LOCATION, location);
		}
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame();
		List<String> playerTokens = game.getPlayerTokens();
	}

}
