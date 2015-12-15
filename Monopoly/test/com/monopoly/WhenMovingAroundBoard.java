package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingAroundBoard {

	MonopolyGame game;
	
	@Before
	public void setUp() throws Exception {
		//setup
		game = new MonopolyGame(4);
	}

	@Test
	public void diceRollInRange() {
		Player player = game.getPlayers().get(0);
		
		for(int i = 0; i < 1000; i++){
			int value = player.rollDice();
			assertTrue(value >= 2);
			assertTrue(value <= 12 );
		}
	}

	@Test
	public void playersLeaveGo() {
		for(Player player : game.getPlayers())
		{
			player.takeTurn();
			assertNotEquals(0, player.getPosition());
		}
	}
	
	@Test
	public void playerMovesAfterRoll() {
		Player player = game.getPlayers().get(0);
		
		int value = player.rollDice();
		player.move(value);
	}
	
	@Test
	public void playerPositionWrapsPastGo() {
		Player player = game.getPlayers().get(0);
		
		int oldPosition = player.getPosition();
		player.move(45);
		int newPosition = player.getPosition();
		assertTrue(newPosition - oldPosition == 5 );
	}
}
