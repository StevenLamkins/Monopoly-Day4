package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOrPassingMoneySquare {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldCollect200OnLandingOnGo() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(34), Token.BATTLESHIP);
		
		testPlayer.takeTurn(new LoadedDie(3));
		
		assertEquals(1700, testPlayer.getMoney());
	}

	
	@Test
	public void shouldPay75OnLandingOnLuxTax() {
		
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(34), Token.BATTLESHIP);
		
		testPlayer.takeTurn(new LoadedDie(2));
		
		assertEquals(1425, testPlayer.getMoney());
		
	}
	

	@Test
	public void shouldPay10PercentOnLandingOnIncomeTaxIfPoor() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(38), Token.BATTLESHIP);
		
		testPlayer.takeTurn(new LoadedDie(3));
		
		assertEquals(1530, testPlayer.getMoney());
	}
	

	@Test
	public void shouldPay200OnLandingOnIncomeTaxIfRich() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(0), Token.BATTLESHIP);
		testPlayer.credit(1500);
		testPlayer.takeTurn(new LoadedDie(2));
		
		assertEquals(2800, testPlayer.getMoney());
	}
	
	
	@Test
	public void shouldCollect200OnPassOverGo() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(38), Token.BATTLESHIP);
		
		testPlayer.takeTurn(new LoadedDie(2));
		
		assertEquals(1700, testPlayer.getMoney());
	}
	
}
