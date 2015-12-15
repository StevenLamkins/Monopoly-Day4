package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WhenSettingUpGame {
	MonopolyGame game;
	List<Player> players;
	
	@Before
	public void setupGame(){
		game = new MonopolyGame(4);
		players = game.getPlayers();
	}

	@Test
	public void shouldHave40Squares() {
		// setup + exercise
		List<Square> squares = game.getSquares();

		//verify
		assertEquals(40, squares.size());
	}
	
	@Test
	public void shouldHaveLessThan9Players() {
		assertTrue(game.getPlayers().size()<9);
	}
	
	@Test
	public void shouldHaveMoreThan2Players() {
		assertTrue(game.getPlayers().size()>2);
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		try{
			MonopolyGame game2 = new MonopolyGame(9);
			fail("Too many players test failure");
		}
		catch (IllegalArgumentException e){
			assertEquals("Too many players",e.getMessage());
		}
	}
	
	@Test
	public void shouldErrorWithTooFewPlayers() {
		try{
			MonopolyGame game2 = new MonopolyGame(1);
			fail("Too few players test failure");
		}
		catch (IllegalArgumentException e){
			assertEquals("Too few players",e.getMessage());
		}
	}

	@Test
	public void shouldStartPlayersOnGo() {
		boolean success = true;
		for (Player player : players) {
			assertTrue(player.getSquare().getId().compareTo("Go")==0);
		}
	}
	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		List<String> tokens = new ArrayList<String>();
		for (Player player : players) {
			assertFalse(tokens.contains(player.getToken()));
		}
	}
	
	@Test
	public void shouldStartPlayersWith1500Money(){
		for (Player player : players) {
			assertTrue(player.getMoney()==1500);
		}
	}
	
}
