package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRunningTheGame {

	@Test
	public void shouldAllowPlayerToMove() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int start = p.getPosition();
		
		int numSpaces = game.takeTurn(p);
		
		int end = p.getPosition();
		
		assertTrue(numSpaces > 0);
	}
	
	@Test
	public void shouldAllowGameToEnd() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.withdraw(p.getBalance());
		
		try {
			game.start();
		} catch (Exception e) {
			fail("Game failed to end!");
		}
	}
	
	@Test
	public void shouldBeAbleToGoToJail() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 30);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
	}

}
