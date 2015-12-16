package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnProperty
{
	private MonopolyGame game;
	Player player;
	
	@Before
	public void setup()
	{
		game = new MonopolyGame(2);
		player = game.getPlayers().get(0);
	}

	@Test
	public void buyUnownedAndAffordableProperty()
	{
		player.move(3);
		Property currentProperty = (Property)player.getCurrentPosition();
		assertEquals(player, currentProperty.getOwner());
	}
	
	@Ignore
	@Test
	public void dontBuyOwnedProperty()
	{
		fail();
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
