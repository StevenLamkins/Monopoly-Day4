package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dicegame.Die;

public class WhenMovingPlayers {

	@Test
	public void playersShouldLeaveGoSquare() {
		MonopolyGame game = new MonopolyGame();
		for (int i = 0; i < MonopolyGame.MAX_NUM_PLAYERS; i++) {
			game.addPlayer();			
		}
		
		List<Player> players = game.getPlayers();
		game.playRound();
		
		for (Player player : players) {
			assertFalse(player.getSquare().getName().equals("Go"));
			
			System.out.println("Player " +  player.getToken() + " " + player.getSquare().getName());
		} 
	}
	
	@Test
	public void playerShouldMoveCorrectAmountOfSquares() {
		Board board = new Board();
		Player player = new Player(board.getStartSquare(), 1);
		List<Die> dice = new ArrayList<>();
		int dieValue1 = 3;
		int dieValue2 = 4;
		dice.add(new LoadedDie(6,dieValue1));
		dice.add(new LoadedDie(6,dieValue2));

		player.takeTurn(dice);
		assertEquals(player.getSquare().getName(), "Square7");		

	}
	
	@Test
	public void playerShouldCircleTheBoard() {
		Board board = new Board();
		
		List<Square> squares = board.getSquares();
		for (Square square : squares) {
			System.out.println(square.getName());
		}

		Player player = new Player(squares.get(38), 1);

		List<Die> dice = new ArrayList<>();
		int dieValue1 = 3;
		int dieValue2 = 4;
		dice.add(new LoadedDie(6,dieValue1));
		dice.add(new LoadedDie(6,dieValue2));

		player.takeTurn(dice);
		
		//Troubleshooting
		for (Square square : squares) {
			System.out.println("Square " + square.getName() + " NextSquare " + square.getNextSquare().getName());
		}		
		
		assertEquals(player.getSquare().getName(), "Square5");		

	}

}
