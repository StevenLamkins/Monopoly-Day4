package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.monopoly.MonopolyGame.Token;

public class WhenSettingUpGame {
	private MonopolyGame game;
	
	@Before
	public void setup() {
		//setup
		game = new MonopolyGame(4);
	}
	
	@Test
	public void shouldHave40Squares() {
		//exercise
		int size = game.getSquares().size();
		
		assertEquals(40, size);
	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		int size = game.getPlayers().size();
		
		assertEquals(4, size);
	}
	

	@Test
	public void shouldErrorWithTooManyPlayers() {
		try {
			MonopolyGameplay badGame = new MonopolyGame(20);
			fail("Did not throw exception.");
		}
		catch (IllegalArgumentException e)
		{
			assertEquals("Too many players!", e.getMessage());
		}
		
	}
	
	@Test
	public void shouldErrorWithTooFewPlayers() {
		try {
			MonopolyGameplay badGame = new MonopolyGame(1);
			fail("Did not throw exception.");
		}
		catch (IllegalArgumentException e)
		{
			assertEquals("Too few players!", e.getMessage());
		}
	}
	
	@Test
	public void shouldStartPlayersOnGo() {
		List<Player> players = game.getPlayers();
		for(PlayerData player : players)
		{
			assertEquals("Go Square", player.getSquare().getName());
		}
	}
	
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		List<Player> players = game.getPlayers();
		List<Token> playerTokens = new ArrayList<>();
		
		for(PlayerData player : players)
		{
			Token token = player.getToken();
			assertFalse(playerTokens.contains(token));
			playerTokens.add(token);
		}
	}

	@Test
	public void shouldHaveTwoDice() {
		int amount = game.getDice().size();
		assertEquals(2, amount);
	}

	@Test
	public void shouldStartPlayersWithMoney() {
		List<Player> players = game.getPlayers();
		
		for(PlayerData player : players)
		{
			assertEquals(1500, player.getMoney());
		}
	}

}
