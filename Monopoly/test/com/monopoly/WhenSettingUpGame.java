package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {

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
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		
		for (Player player : players) {
			Square location = player.getLocation();
			assertSame(game.getSquares().get(0), location);
		}
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			int match = 0;
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getToken().equals(player.getToken())) {
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
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		
		//verify
		for (int i = 0; i < players.size(); i++) {
			assertEquals(STARTING_BALANCE, players.get(i).getBalance());
		}
	}
	
	@Test
	public void shouldHaveUniqueSquareNames() {
		MonopolyGame game = new MonopolyGame();
		List<Square> squares = game.getSquares();

		//private String[] names = {"Mediterranean", "Baltic", "Oriental", "Vermont", "Connecticut", "St. Charles Place", "States", "Virginia", "St. James Place", "Tennessee", "New York", "Kentucky", "Indiana", "Illinois", "Atlantic", "Ventnor", "Marvin Gardens", "Pacific", "North Carolina", "Pennsylvania", "Park Place", "Boardwalk", "Electric Company", "Water Works", "Reading Railroad", "Pennsylvania Railroad", "B&O Railroad", "Short Line Railroad", "Community Chest", "Income Tax", "Chance", "Jail", "Community Chest", "Free Parking", "Chance", "Go to Jail", "Community Chest", "Chance", "Luxury Tax"};
		
		assertEquals("Go", squares.get(0).getName());
		assertEquals("Mediterranean", squares.get(1).getName());
		assertEquals("Community Chest", squares.get(2).getName());
		assertEquals("Baltic", squares.get(3).getName());
		assertEquals("Income Tax", squares.get(4).getName());
		assertEquals("Reading Railroad", squares.get(5).getName());
		
	}
	
	// @Test(expected=IllegalArgumentException.class)

}
