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
	

	
	@Test
	public void shouldHave40Squares() {
		
		//setup

		game = new MonopolyGame(2);
		players =  game.getPlayers();
		squares =  game.getSquares();
		
		//verify
		assertEquals(40, squares.size());
	}


	@Test
	public void shouldHaveCorrectNumberOfplayers() {
		
		//setup

		game = new MonopolyGame(2);
		players =  game.getPlayers();
		squares =  game.getSquares();
		//verify
		assertTrue(players.size() == 2);
		
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		//setup
		game = new MonopolyGame(9);
		players =  game.getPlayers();
		squares =  game.getSquares();

		
        //verify
		assertTrue(players.size() > 8);
	}
	

	@Test
	public void shouldErrorWithTooFewPlayers() {
		//setup
		game = new MonopolyGame(1);
		players =  game.getPlayers();
		squares =  game.getSquares();

		
        //verify
		assertTrue(players.size() < 2);
	}


	@Test
	public void shouldStartPlayersOnGo() {
		
		//setup
		game = new MonopolyGame(2);
		players =  game.getPlayers();
		squares =  game.getSquares();

		
        //verify
		for (Player p : players)
		{
		   assertEquals("Go", p.isOnGo());
		}

		
		
		
	}

	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		
		//setup
		game = new MonopolyGame(2);
		players =  game.getPlayers();
		squares =  game.getSquares();
		
       //verify
		int counter =1;
		for (Player p : players)
		{
			
		   assertEquals("king"+counter, p.getToken());
		   counter++;
		}

	}

}
