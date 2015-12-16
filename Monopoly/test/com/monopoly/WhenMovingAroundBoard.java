package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.monopoly.MonopolyGame.Token;

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
	
	@Test
	public void playerRollsDoubles(){
		LoadedDie dieOne = new LoadedDie(64564);
		LoadedDie dieTwo = new LoadedDie(64564);
		List<Die> dice = new ArrayList<>();
		dice.add(dieOne);
		dice.add(dieTwo);
		
		Player player = new Player(game.getSquares().get(0), Token.Battleship, dice);
		
		assertEquals(3, player.takeTurn());
		
	}
	
	@Test
	public void playDistanceGame()
	{
		game.playDistanceGame();
	}
}
