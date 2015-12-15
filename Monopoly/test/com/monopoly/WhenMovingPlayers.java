package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.dicegame.Die;

public class WhenMovingPlayers {

	@Test
	public void shouldLeaveGoSquare() {

		
		// setup + exercise
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		Square goSquare = game.getGoSquare();
		
		game.playRound();
		
		for (Player player : players) {
			assertNotEquals(goSquare, player.getCurrentSquare());
		}

	}

	@Test
	public void shouldMovePlayerCorrectNumberOfSquare() {
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		Square goSquare = game.getGoSquare();
		
		game.playRound();
		
		for (Player player : players) {
			assertNotEquals(goSquare, player.getCurrentSquare());
		}
		
		
		fail("Not yet implemented");
	}

	@Test
	public void shouldCircleTheBoard() {
		fail("Not yet implemented");
	}

}
