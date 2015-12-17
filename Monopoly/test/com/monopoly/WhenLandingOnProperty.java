package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnProperty
{
	private MonopolyGame game;
	Player playerOne, playerTwo;
	
	@Before
	public void setup()
	{
		game = new MonopolyGame(2);
		playerOne = game.getPlayers().get(0);
		playerTwo = game.getPlayers().get(1);
	}

	@Test
	public void buyUnownedAndAffordableProperty()
	{
		Property expectedProperty = (Property) game.getSquares().get(3);
		playerOne.move(3);
		Property playerProperty = (Property)playerOne.getCurrentPosition();
		assertEquals(expectedProperty,playerProperty);
	}
	
	
	@Test
	public void dontBuyOwnedProperty()
	{
		playerTwo.move(3);
		Property actualProperty = (Property) game.getSquares().get(3);
		assertTrue(!playerTwo.getName().equals(actualProperty.getOwner()));
	}
	
	@Ignore
	@Test
	public void dontBuyUnaffordableProperty()
	{
		fail();
	}
	
	@Ignore
	@Test
	public void visitorPayRentToOwner()
	{
		fail();
	}
	
	@Ignore
	@Test
	public void dontPayRentForOwnedProperty()
	{
		fail();
	}
	
	@Ignore
	@Test
	public void railroadRentIs50()
	{
		fail();
	}
	
	@Ignore
	@Test
	public void utilityRentIs()
	{
		fail();
	}
}
