package com.monopoly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.dicegame.Die;

public class WhenMovingPlayers {
	
	@Test
	public void shouldLeaveGoSquare(){
		MonopolyGame game = new MonopolyGame(8);
		List<Player> players = game.getPlayers();
		Square goSquare = game.getSquares().get(0);
		
		game.playRound();
		
		for (Player player : players) {
			assertNotEquals(goSquare, player.getLocation());
		}
	}
	@Test
	public void shouldMovePlayerCorrectNumberOfSquares(){
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(0));
		Square expectedLocation = board.getSquares().get(5);
		
		testPlayer.takeTurn(new LoadedDie(2), new LoadedDie(3));
		
		assertEquals(expectedLocation, testPlayer.getLocation());
	}
	@Test
	public void shouldCircleTheBoard(){
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(37));
		Square expectedLocation = board.getSquares().get(2);
		
		testPlayer.takeTurn(new LoadedDie(3), new LoadedDie(2));
		
		assertEquals(expectedLocation, testPlayer.getLocation());
	}
}
