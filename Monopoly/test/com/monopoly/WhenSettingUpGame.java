package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {
	
	private static final int FIRST_LOCATION = 0;
	private static final int STARTING_BALANCE = 1500;

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
		List<String> players = game.getPlayerNames();
		
		for (String name : players) {
			int location = game.getPlayerLocation(name);
			assertEquals(FIRST_LOCATION, location);
		}
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame();
		List<String> playerTokens = game.getPlayerTokens();
		for (String token : playerTokens) {
			int match = 0;
			for (int i = 0; i < playerTokens.size(); i++) {
				if (playerTokens.get(i).equals(token)) {
					match++;
				}
			}
			assertTrue(match < 2);
		}
	}

	@Test
	public void shouldHave2Dice() {
		// setup and exercise
		MonopolyGame game = new MonopolyGame();
		List<Die> dice = game.getDice();
		
		// verify
		assertEquals(2, dice.size());
	}

	@Test
	public void shouldHave1500DollarsPerPlayer() {
		// setup and exercise
		MonopolyGame game = new MonopolyGame();
		List<Player> players = game.getPlayers();
		
		//verify
		for (int i = 0; i < players.size(); i++) {
			assertEquals(STARTING_BALANCE, players.get(i).getBalance());
		}
	}

}
