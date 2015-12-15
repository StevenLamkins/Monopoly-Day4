package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class WhenSettingUpGame {
	MonopolyGame game;
	int numplayers = 4;
	
	@Before
	public void setup(){
		game = new MonopolyGame(numplayers);
	}
	
	@Test
	public void shouldHave40Squares() {
		//setup + exercise
		
		List<Square> squares = game.getSquares();
		
		//verify
		assertEquals(40, squares.size());
	}
	

	@Test
	public void shouldHaveCorrectNumberOfPlayers() {	
		assertEquals(numplayers, game.getNumberOfPlayers());
	}
	
	//@Ignore
	@Test
	public void shouldErrorWithTooManyPlayers() {
		assertFalse(game.getNumberOfPlayers() > 8 );
	}
	
	//@Ignore
	@Test
	public void shouldErrorWithTooFewPlayers() {
		assertFalse(game.getNumberOfPlayers() < 2 );
	}
	
	//@Ignore
	@Test
	public void shouldStartPlayersOnGo() {
		//fail("not yet implemented");
		
		List<Player> players = game.getPlayers();
		
		for (Player aplayer : players) {
			System.out.println("Location: " + aplayer.getLocation().getName());
			assertEquals("GO", aplayer.getLocation().getName());
		}
		
	}

	@Ignore
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		List<Player> players = game.getPlayers();
		player.getToken();
	}
	

}
