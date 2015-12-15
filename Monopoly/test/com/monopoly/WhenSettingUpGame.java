package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame {
	
	MonopolyGame game = new MonopolyGame();
	
	@Test
	public void shouldHave40Squares() {
	
		//exercise
		List<Square> squares = game.getSquares();
		assertEquals (40, squares.size());
	}
	
	@Test
	public void shouldHaveTheSame40Squares() {

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

		//excercise
		game.setNumPlayers(5);		
		List<Player> players = game.getPlayers();
		assertEquals (5, players.size());
	}

	@Test
	public void shouldDefaultToMaxWithTooManyPlayers() {
		game.setNumPlayers(9);
		List<Player> players = game.getPlayers();
		assertEquals(8, players.size());
	}
	
	@Test
	public void shouldDefaultToMinWithTooFewPlayers() {
		game.setNumPlayers(1);
		
		List<Player> players = game.getPlayers();
		assertEquals(2, players.size());
	}
	@Test
	public void shouldDefaultToMinsWithZeroPlayers() {
		game.setNumPlayers(0);
		
		List<Player> players = game.getPlayers();
		assertEquals(2, players.size());
	}
	@Test
	public void shouldInitializeWith2Players () {
		List<Player> players = game.getPlayers();
		assertEquals(2, players.size());
	}
	
	@Test
	public void shouldStartWithPlayersOnGo() {
		game.setNumPlayers(8);
		
		List<Square> squares = game.getSquares();
		Square firstSquare = squares.get(0);
		
		for (Player player: game.getPlayers()) {
			Square currSquare = player.getPosition();
			assertSame (currSquare, firstSquare);
		}
	}
	
	
	
	@Test
	public void shouldSHaveUniqueTokensForPlayers() {
		game.setNumPlayers(4);
		
		assertEquals (Token.Dog, game.getPlayers().get(0).getToken());
		assertEquals (Token.Wheelbarrow, game.getPlayers().get(1).getToken());
		assertEquals (Token.Tophat, game.getPlayers().get(2).getToken());
		assertEquals (Token.Thimble, game.getPlayers().get(3).getToken());
	}
	
	@Test
	public void shouldHaveInitialBalance() {
		game.setNumPlayers(8);
		
		for (Player player : game.getPlayers()) {
			assertEquals (1500, player.getBalance());
			
		}
	}
}
