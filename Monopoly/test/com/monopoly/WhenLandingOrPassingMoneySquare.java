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

	@Ignore
	@Test
	public void shouldPay75OnLandingOnLuxTax() {
		
	}
	
	@Ignore
	@Test
	public void shouldPay10PercentOnLandingOnIncomeTaxIfPoor() {
		
	}
	
	@Ignore
	@Test
	public void shouldPay200OnLandingOnIncomeTaxIfRich() {
		
	}
	
	@Ignore
	@Test
	public void shouldCollect200OnPassOverGo() {
		
	}
	
}
