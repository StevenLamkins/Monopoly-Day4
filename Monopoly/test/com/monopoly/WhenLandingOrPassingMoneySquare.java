package com.monopoly;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOrPassingMoneySquare {

	@Test
	public void shouldCollect200ForLandingOnGo() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getSquares()
				.get(36));

		testPlayer.takeTurn(new LoadedDie(1), new LoadedDie(3));
		
		assertEquals(1700, testPlayer.getMoney());
		

	}

	@Ignore
	@Test
	public void shouldPay75ForLandingOnLuxuryTax() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getStartSquare());

	}

	@Ignore
	@Test
	public void shouldPay10PercentForLandingOnIncomeTaxIfPoor() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getStartSquare());

	}

	@Ignore
	@Test
	public void shouldPay200ForLandingOnIncomeTaxIfRich() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getStartSquare());

	}

}
