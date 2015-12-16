package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	
	@Test
	public void shouldStartPlayersOnGo()
	{
		for (int j = 2; j < 9; j++) {
			MonopolyGame game = new MonopolyGame(j);
			List<Player> players = game.getPlayers();
			List<Square> squares = game.getSquares();
			Square goSquare= squares.get(0);
			for (Player p : players) {
				assertEquals(goSquare,p.getCurrentPosition());
			}
		}
	}
	
	@Test
	public void shouldHaveUniqueTokenForPlayers()
	{
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		assertEquals(Token.Dog.toString(), players.get(0).getName());
		assertEquals(Token.Iron.toString(), players.get(1).getName());
		assertEquals(Token.Shoe.toString(), players.get(2).getName());
		assertEquals(Token.Racecar.toString(), players.get(3).getName());
		assertEquals(Token.Battleship.toString(), players.get(4).getName());
		assertEquals(Token.Thimble.toString(), players.get(5).getName());
		assertEquals(Token.Wheelbarrow.toString(), players.get(6).getName());
		assertEquals(Token.TopHat.toString(), players.get(7).getName());
		
//		MonopolyGame game = new MonopolyGame(x);
//		for(Player p : game.getPlayers())
//		{
//			
//		}
	}
	
	

}
