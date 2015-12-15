package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WhenPlayingTheGame {
	
	@Test
	public void playerShouldMoveWhenRollingDice() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Square startSquare = currentPlayer.getSquare();
		Die die = new Die(6, 2);
		currentPlayer.takeTurn(die);
		assertNotEquals(startSquare, currentPlayer.getSquare());
	}
	
	@Test
	public void gameShouldAllowSpaceJumping() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		currentPlayer.moveToSquare("free parking");
		assertEquals(currentPlayer.getSquare().getId(), "free parking");
	}
	
	@Test
	public void gameShouldReward200AfterPassingGo() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 20);
		currentPlayer.takeTurn(die);
		assertEquals(currentPlayer.getMoney(), 1700);
	}

}
