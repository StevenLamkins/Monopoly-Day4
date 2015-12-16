package com.monopoly;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WhenMovingAroundTheBoard {

	@Before
	public void setUp() throws Exception {
		// MonopolyGame game = new MonopolyGame(numplayers);
	}

	@Test
	public void allPlayersShouldLeaveGoSquare() {
		MonopolyGame game = new MonopolyGame(4);

		List<Player> players = game.getPlayers();
		for (Player aplayer : players) {
			aplayer.takeTurn(game.getaDie());
			assertNotEquals("Go Square", aplayer.getLocation().getName());
		}
	}

	@Test
	public void playersShouldMoveCorrectSquare() {
		MonopolyGame game = new MonopolyGame(4);

		List<Player> players = game.getPlayers();
		players.get(0).takeTurn(new LoadedDie(3));
		assertEquals("Square6", players.get(0).getLocation().getName());

	}

	@Test     
	public void playersShouldMoveMoveArroundTheBoard() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		players.get(0).takeTurn(new LoadedDie(20));   
		assertEquals("Go Square", players.get(0).getLocation().getName());
	}

}
