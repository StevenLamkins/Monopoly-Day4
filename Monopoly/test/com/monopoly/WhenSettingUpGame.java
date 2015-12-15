package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenSettingUpGame
{

	
	@Test
	public void shouldHave40Squares()
	{
		for (int i = 2; i < 9; i++){
			MonopolyGame game = new MonopolyGame(i);
			List<Square> squares = game.getSquares();
			
			assertEquals(40,squares.size());
		}
	}
	
	@Ignore
	@Test
	public void shouldHaveCorrectPlayerOrder()
	{
		List<Player> players = new ArrayList<>();
		for(int i = 2; i < 9; i++)
		{			
			MonopolyGame game = new MonopolyGame(i);
			
			for(Player temp:players)
			{
				game.roll();
			}
		}

		fail("Not yet implemented");

	}
	
	@Ignore
	@Test
	public void shouldHaveCorrectNumberOfPlayers()
	{
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldErrorWithTooManyPlayers()
	{
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldErrorWithTooFewPlayers()
	{
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldStartPlayersOnGo()
	{
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHaveUniqueTokenForPlayers()
	{
		fail("Not yet implemented");
	}
	
	
	

}
