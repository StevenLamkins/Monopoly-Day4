package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingAroundBoard {

	@Test
	public void shouldMovePlayersCorrectNumberOfSquares() {
		MonopolyGame game = new MonopolyGame();
		List<Die> dice = game.getDice();
		game.playTurn(0);
		int sum = dice.get(0).getFaceValue() + dice.get(1).getFaceValue();
		assertEquals(game.getPlayers().get(0).getLocation().getPosition(), sum);
	}

	@Test
	public void shouldAllowPlayersToCircleBoard() {
		MonopolyGame game = new MonopolyGame();
		game.getPlayers().get(0).setLocation(game.getSquares().get(39));
		game.playTurn(0);
		assertTrue(game.getPlayers().get(0).getLocation().getPosition() < 40);
	}

	@Test
	public void shouldMovePlayersOffGoSquare() {
		MonopolyGame game = new MonopolyGame(8);
		game.playRound();
		for (Player player : game.getPlayers()) {
			assertFalse(player.getLocation().getPosition() == 0);
		}
	}

}

// testPlayer.takeTurn(new Die(){public int roll(){return 2;}});
