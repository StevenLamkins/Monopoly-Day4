package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WhenSettingUpGame {
	MonopolyGame game;
	
	@Before
	public void setupGame(){
		game = new MonopolyGame(4);
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
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		fail("Not yet implemented");
	}

}
