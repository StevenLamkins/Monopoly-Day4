package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {

	private MonopolyGame game;
	private List<Player> players;
	private List<Square> squares;
	private Die[] dice;
	
	
	
	@Test
	public void whichPlayerGoesNext() {
		
		//setup
        int currentPlayerPosition =1;
		game = new MonopolyGame(8);
		players =  game.getPlayers();
        Player currentPlayer = players.get(currentPlayerPosition);
        //verify
		assertEquals(currentPlayerPosition +1, Integer.parseInt(currentPlayer.getToken().substring(5)));


	}

	@Test
	public void shoulPlayerHas1500() {
		
		//setup

		game = new MonopolyGame(2);
		players =  game.getPlayers();


		for (Player p :players) {
			//verify
			assertEquals(1500, p.getFund());
		}

	}
	@Test
	public void shouldHaveTwoDice() {
		
		//setup

		game = new MonopolyGame(2);
		dice = game.getDice();
		

		//verify
	    assertEquals(2, dice.length);

	}

	
	@Test
	public void shouldHave40Squares() {
		
		//setup

		game = new MonopolyGame(2);
		squares =  game.getSquares();
		
		//verify
		assertEquals(40, squares.size());
	}


	@Test
	public void shouldHaveCorrectNumberOfplayers() {
		
		//setup

		game = new MonopolyGame(2);
		players =  game.getPlayers();
		//verify
		assertTrue(players.size() == 2);
		
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		//setup
		game = new MonopolyGame(9);
		players =  game.getPlayers();

		
        //verify
		assertTrue(players.size() > 8);
	}
	

	@Test
	public void shouldErrorWithTooFewPlayers() {
		//setup
		game = new MonopolyGame(1);
		players =  game.getPlayers();

		
        //verify
		assertTrue(players.size() < 2);
	}


	@Test
	public void shouldStartPlayersOnGo() {
		
		//setup
		game = new MonopolyGame(2);
		players =  game.getPlayers();

		
        //verify
		for (Player p : players)
		{
		   assertTrue( p.isOnGo());
		}

		
		
		
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		
		//setup
		game = new MonopolyGame(2);
		players =  game.getPlayers();
		
       //verify
		int counter =1;
		for (Player p : players)
		{
			
		   assertEquals("TOKEN"+counter, p.getToken());
		   counter++;
		}

	}

}
