package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenLandingOnPurchasableProperty {

	MonopolyGame game;
	
	@Before
	public void setUp() throws Exception {
		//setup
		game = new MonopolyGame(4);
	}

	@Test
	public void purchaseProperty() {
		Player player = game.getPlayers().get(0);
		int propertyAmount = player.getProperties().size();
		player.move(1);
		assertTrue(player.getProperties().size() > propertyAmount);
	}
	
	@Test
	public void payingRent() {
		Player playerOne = game.getPlayers().get(0);
		Player playerTwo = game.getPlayers().get(1);
		
		playerOne.move(1);
		playerTwo.move(1);
		
		assertEquals(1498, playerTwo.getMoney());
	}

}
