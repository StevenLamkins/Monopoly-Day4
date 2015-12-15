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
		

	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers()
	{
		
		for (int i = 2; i < 9; i++) {
			MonopolyGame game = new MonopolyGame(i);
			assertTrue(game.getPlayers().size() >= 2);
		}
		
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers()
	{
		try
		{
			MonopolyGame game = new MonopolyGame(9);
			fail("Did not throw error");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	@Test
	public void shouldErrorWithTooFewPlayers()
	{
		try
		{
			MonopolyGame game = new MonopolyGame(1);
			fail("Did not throw error");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.toString());
		}
		
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
