package com.monopoly;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void shouldPay75ForLandingOnLuxuryTax() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getSquares()
				.get(36));
		testPlayer.takeTurn(new LoadedDie(4), new LoadedDie(4));

		assertEquals(1425, testPlayer.getMoney());

	}

	@Test
	public void shouldPay10PercentForLandingOnIncomeTaxIfPoor() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getSquares()
				.get(36));
		testPlayer.takeTurn(new LoadedDie(1), new LoadedDie(1));

		assertEquals(1350, testPlayer.getMoney());

	}

	@Test
	public void shouldPay200ForLandingOnIncomeTaxIfRich() {
		Board board = new Board();
		Player testPlayer = new Player(Token.Battleship, board.getSquares()
				.get(36));
		testPlayer.setMoney(2000);
		testPlayer.takeTurn(new LoadedDie(1), new LoadedDie(1));

		assertEquals(1800, testPlayer.getMoney());


	}

}
