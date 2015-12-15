package com.monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.monopoly.exceptions.WrongNumberOfPlayersException;

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
	public void shouldContain8Pieces() {
		assertEquals(Piece.values().length, 8);
	}
	
	@Test(expected=WrongNumberOfPlayersException.class)
	public void shouldErrorWithTooFewPlayers() {
		new MonopolyGame(1);
	}
	
	@Test(expected=WrongNumberOfPlayersException.class)
	public void shouldErrorWithTooManyPlayers() {
		new MonopolyGame(9);
	}
	
	@Test
	public void shouldStartPlayersOnGo() {
		MonopolyGame game = new MonopolyGame(2);
		
		List<Player> players = game.getPlayers();
		
		for (Player p : players) {
			assertEquals(Square.Go, game.getPlayerSquare(p));
		}
	}
	
	@Test
	public void shouldHave1500ToStart() {
		MonopolyGame game = new MonopolyGame(2);
		
		List<Player> players = game.getPlayers();
		
		for (Player p : players) {
			assertEquals(p.getBalance(), 1500);
		}
	}
	
	@Test
	public void shouldHaveUniquePiecesForPlayers() {
		Set<Piece> pieces = new HashSet<>();
		
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		
		for (Player p : players) {
			pieces.add(p.getPiece());
		}
		
		assertEquals(pieces.size(), players.size());
	}
	
	@Test
	public void shouldHaveHouseBuildingCostForEachColor() {
		for (Square s : Square.values()) {
			switch (s.getGroup()) {
				case RAILROAD:
				case UTILITIES:
				case NONE:
					break;
				default:
					assertTrue(s.getHouseBuildingCost() > 0);
					break;
			}
		}
	}

}
