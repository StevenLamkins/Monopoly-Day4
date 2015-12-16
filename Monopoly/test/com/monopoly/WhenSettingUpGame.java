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
		
		assertEquals("Go", squares.get(0).getName());
		assertEquals("Mediterranean", squares.get(1).getName());
		assertEquals("Community Chest", squares.get(2).getName());
		assertEquals("Baltic", squares.get(3).getName());
		assertEquals("Income Tax", squares.get(4).getName());
		assertEquals("Reading Railroad", squares.get(5).getName());
		assertEquals("Oriental", squares.get(6).getName());
		assertEquals("Chance", squares.get(7).getName());
		assertEquals("Vermont", squares.get(8).getName());
		assertEquals("Connecticut", squares.get(9).getName());
		assertEquals("Jail", squares.get(10).getName());
		assertEquals("St. Charles Place", squares.get(11).getName());
		assertEquals("Electric Company", squares.get(12).getName());
		assertEquals("States", squares.get(13).getName());
		assertEquals("Virginia", squares.get(14).getName());
		assertEquals("Pennsylvania Railroad", squares.get(15).getName());
		assertEquals("St. James Place", squares.get(16).getName());
		assertEquals("Community Chest", squares.get(17).getName());
		assertEquals("Tennessee", squares.get(18).getName());
		assertEquals("New York", squares.get(19).getName());
		assertEquals("Free Parking", squares.get(20).getName());
		assertEquals("Kentucky", squares.get(21).getName());
		assertEquals("Chance", squares.get(22).getName());
		assertEquals("Indiana", squares.get(23).getName());
		assertEquals("Illinois", squares.get(24).getName());
		assertEquals("B&O Railroad", squares.get(25).getName());
		assertEquals("Atlantic", squares.get(26).getName());
		assertEquals("Ventnor", squares.get(27).getName());
		assertEquals("Water Works", squares.get(28).getName());
		assertEquals("Marvin Gardens", squares.get(29).getName());
		assertEquals("Go to Jail", squares.get(30).getName());
		assertEquals("Pacific", squares.get(31).getName());
		assertEquals("North Carolina", squares.get(32).getName());
		assertEquals("Community Chest", squares.get(33).getName());
		assertEquals("Pennsylvania", squares.get(34).getName());
		assertEquals("Short Line Railroad", squares.get(35).getName());
		assertEquals("Chance", squares.get(36).getName());
		assertEquals("Park Place", squares.get(37).getName());
		assertEquals("Luxury Tax", squares.get(38).getName());
		assertEquals("Boardwalk", squares.get(39).getName());
		
	}
	
	// @Test(expected=IllegalArgumentException.class)

}
