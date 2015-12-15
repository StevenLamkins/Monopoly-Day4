package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WhenMovingPlayers {

	@Test
	public void playersShouldLeaveGoSquare() {
		MonopolyGame game = new MonopolyGame();
		for (int i = 0; i < MonopolyGame.MIN_NUM_PLAYERS; i++) {
			game.addPlayer();			
		}
		
		List<Player> players = game.getPlayers();
		game.playRound();
		
		for (Player player : players) {
			assertFalse(player.getSquare().getName().equals("Go"));
		} 
	}

}
