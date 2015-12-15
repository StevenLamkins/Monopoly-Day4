package com.monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
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
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void shouldErrorWithTooManyPlayers() {
		new MonopolyGame(9);
	}
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void shouldErrorWithTooFewPlayers() {
		new MonopolyGame(1);
	}
	
	//@Ignore
	@Test
	public void shouldStartPlayersOnGo() {
		//fail("not yet implemented");
		
		List<Player> players = game.getPlayers();
		
		for (Player aplayer : players) {
			assertEquals("GO", aplayer.getLocation().getName());
		}	
	}

	//@Ignore
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		List<Player> players = game.getPlayers();

		assertEquals("TERRIER", players.get(0).getToken());
		assertEquals("BATTLESHIP",  players.get(1).getToken());
		assertEquals("CAR",  players.get(2).getToken());
		assertEquals("HAT",  players.get(3).getToken());
	}
	
	//@Ignore
	@Test
	public void shouldPlayersHaveMoney() {
		//fail("not yet implemented");
		
		List<Player> players = game.getPlayers();
		
		for (Player aplayer : players) {
			assertEquals(1500, aplayer.getMoney(), .1);
		}	
	}
	
	//@Ignore
	@Test
	public void shouldHave2Dice() {
		assertEquals(2, game.getDice().size());
			
	}


	

}
