package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldHave40Squares() {
		// setup
		MonopolyGame game = new MonopolyGame();
		
		//exercise
		List<Square> squares = game.getSquares();
		assertEquals (40, squares.size());
	}
	
	@Test
	public void shouldHaveTheSame40Squares() {
		// setup
		MonopolyGame game = new MonopolyGame();
		
		//exercise
		List<Square> squares1 = game.getSquares();
		Square firstSquareFromOne = squares1.get(0);
		
		List<Square> squares2 = game.getSquares();
		Square firstSquareFromTwo = squares2.get(0);
		
		assertSame(firstSquareFromOne, firstSquareFromTwo);
		assertEquals (40, squares1.size());
	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers() { // means that the chosen number of players are created 
		// setup
		MonopolyGame game = new MonopolyGame();
		
		//excercise
		game.setNumPlayers(5);		
		List<Player> players = game.getPlayers();
		assertEquals (5, players.size());
	}

	@Ignore
	@Test
	public void shouldErrorWithTooManyPlayers() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldErrorWithTooFewPlayers() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldStartWithPlayersOnGo() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldSHaveUniqueTokensForPlayers() {
		fail("Not yet implemented");
	}
}
