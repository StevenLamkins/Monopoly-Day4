package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingAroundBoard {
MonopolyGame game = new MonopolyGame();
	@Ignore
	@Test
	public void PlayerShouldLeaveGoSquare() {
		game.setNumPlayers(8);
		
		List<Square> squares = game.getSquares();
		Square firstSquare = squares.get(0);
		game.playRound();
		for (Player player: game.getPlayers()) {
			Square currSquare = player.getPosition();
			assertNotSame(currSquare, firstSquare);
		}
	}
	
	@Test
	public void PlayerShouldMove2Squares() {
		List<Square> squares = game.getSquares();
		Square firstSquare = squares.get(0);
		Player player = game.getPlayers().get(0);
		player.takeTurn();
		assertNotNull(player.getPosition());
		assertNotSame(player.getPosition(), firstSquare);
		}
	}

