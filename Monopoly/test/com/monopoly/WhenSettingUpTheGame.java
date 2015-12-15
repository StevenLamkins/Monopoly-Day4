package com.monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class WhenSettingUpTheGame {

	@Test
	public void shouldHave40Squares() {
		// Setup + Exercise
		MonopolyGame game = new MonopolyGame();
		
		// Verify
		assertEquals(40, game.getNumSquares());
	}
	
	@Test
	public void shouldAcceptAtLeast2Players() {
		// Setup + Exercise
		try {
			MonopolyGame game = new MonopolyGame(2);
		} catch (Exception e) {
			fail("Creating game with 2 players failed");
		}
	}
	
	@Test
	public void shouldAcceptUpTo8Players() {
		// Setup + Exercise
		try {
			MonopolyGame game = new MonopolyGame(8);
		} catch (Exception e) {
			fail("Creating game with 8 players failed");
		}
	}
	
	@Test
	public void shouldErrorWithTooFewPlayers() {
		// Setup + Exercise
		try {
			MonopolyGame game = new MonopolyGame(1);
			fail("Creating game with 1 player didn't fail");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		// Setup + Exercise
		try {
			MonopolyGame game = new MonopolyGame(9);
			fail("Creating game with 9 players didn't fail");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void shouldStartPlayersOnGo() {
		MonopolyGame game = new MonopolyGame(2);
		
		List<Player> players = game.getPlayers();
		
		for (Player p : players) {
			assertEquals("Go", game.getPlayerSquareName(p));
		}
	}
	
	@Test
	public void shouldHaveUniquePiecesForPlayers() {
		Set<Integer> tokens = new HashSet<>();
		
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		
		for (Player p : players) {
			tokens.add(p.getToken());
		}
		
		assertEquals(tokens.size(), players.size());
	}

}
