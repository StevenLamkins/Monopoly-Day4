package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {

	@Test
	public void shouldHave40Squares() {

		// setup
		MonopolyGame game = new MonopolyGame();

		game.addPlayer(Token.BattleShip);
		game.addPlayer(Token.Dog);
		game.addPlayer(Token.RaceCar);
		game.addPlayer(Token.Hat);
		
		game.start();

		// verify
		List<Square> squares = game.getSquares();
		assertEquals(40, squares.size());
	}

	@Test
	public void shouldHaveCorrectNumberOfPlayers() {

		// setup
		MonopolyGame game = new MonopolyGame();
		game.addPlayer(Token.BattleShip);
		game.addPlayer(Token.Dog);
		game.addPlayer(Token.RaceCar);
		game.addPlayer(Token.Hat);
		
		game.start();
		int initNumPlayers = 4;

		int numPlayers = game.getNumberPlayers();
		assertEquals(initNumPlayers, numPlayers);
	}


	@Test
	public void shouldErrorWithTooManyPlayers() {

		MonopolyGame game = new MonopolyGame();

		try {
			for (Token token : Token.values()) {
				game.addPlayer(token);
			}
			game.addPlayer(Token.Iron);
			game.start();
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue("Too Many Players", true);
		}
	}

	@Test
	public void shouldErrorWithTooFewPlayers() {

		MonopolyGame game = new MonopolyGame();
		try {
			game.addPlayer(Token.Iron);
			game.start();
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Too Few Players", e.getMessage());
		}
	}

	@Test
	public void shouldStartPlayersOnGo() {

		MonopolyGame game = new MonopolyGame();
		game.addPlayer(Token.BattleShip);
		game.addPlayer(Token.Dog);
		game.addPlayer(Token.RaceCar);
		game.addPlayer(Token.Shoe);
		game.start();
		List<Player> players = game.getPlayers();
		for (Player player : players) {
			Square square = player.getSquare();

			assertEquals("Go", square.getName());
		}
	}
	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		MonopolyGame game = new MonopolyGame();
		List<String> tokenList = new ArrayList<String>();
		for (Token token : Token.values()) {
			game.addPlayer(token);	
			if(tokenList.contains(token)) {
				fail();
			}
			tokenList.add(token.toString());
		}		
		assertTrue(true);
	}
	
	@Test
	public void shouldBeAbleToAddPlayer() {
		
		//Setup
		MonopolyGame game = new MonopolyGame();
		int currentNumPlayers = 0;
		game.addPlayer(Token.Thimble);		
		
		assertEquals(currentNumPlayers + 1, game.getNumberPlayers());
	}
	
	@Test
	public void playerShouldStartWithMoney() {
		
		//Setup
		Board board = new Board();
		Player player = new Player(board.getStartSquare(), Token.BattleShip);		
		
		assertEquals(1500.0, player.getAccountBalance(), 0.001);
	}
	
}
