package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.monopoly.MonopolyGame.Token;

public class WhenLandingOnProperty {

	MonopolyGame game;
	
	@Before
	public void setUp() throws Exception {
		//setup
		game = new MonopolyGame(4);
	}

	@Test
	public void whenPayingRailroadRent() {
		Player playerOne = game.getPlayers().get(0);
		Player playerTwo = game.getPlayers().get(1);
		
		int amount = playerTwo.getMoney();
		
		playerOne.move(5);
		playerOne.move(10);
		playerTwo.move(5);

		assertEquals(amount, playerTwo.getMoney() + 50);
	}
	
	@Test
	public void whenPayingUtilityRent() {
		Player playerOne = game.getPlayers().get(0);
		LoadedDie dieOne = new LoadedDie(6);
		LoadedDie dieTwo = new LoadedDie(6);
		List<Die> dice = new ArrayList<>();
		dice.add(dieOne);
		dice.add(dieTwo);
		
		Player playerTwo = new Player(game.getSquares().get(0), Token.Battleship, dice);
		
		int amount = playerTwo.getMoney();
		
		playerOne.move(12);
		playerOne.move(16);
		playerTwo.move(playerTwo.rollDice());
		
		assertEquals(amount - 120, playerTwo.getMoney());
	}

}
