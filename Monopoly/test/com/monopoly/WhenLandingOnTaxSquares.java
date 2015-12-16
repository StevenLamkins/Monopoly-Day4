package com.monopoly;

import static org.junit.Assert.*;

import org.junit.*;

public class WhenLandingOnTaxSquares {
	
	Square firstSquare  = new Square("First", 1);
	Square square2 = new Square("2", 2);
	Square square3 = new LuxuryTaxSquare("Luxury", 3);
	Square square4 = new IncomeTaxSquare("IncomeTax", 4);
	
	@Before
	public void setupSquares() {
		firstSquare.setNext(square2);
		square2.setNext(square3);
		square3.setNext(square4);
		square4.setNext(firstSquare);
	}

	@Test
	public void shouldChargeLuxuryTax() {
		
		Player player = new Player(Token.Boot, firstSquare);
		
		player.takeTurn(new LoadedDice(2));
		
		assertEquals (1425, player.getBalance());
	}
	
	@Test
	public void shouldPay10PercentforLandingOnIncomeTaxIfPoor1500() { //<2000
		
		Player player = new Player (Token.Iron, firstSquare);
		
		player.takeTurn(new LoadedDice(3));
		
		assertEquals (1500-150, player.getBalance());
		
	}
	
	@Test
	public void shouldPay10PercentForLandingOnIncomeTaxIf1900 () {
		
		Player player = new Player(Token.Racecar, firstSquare);
		player.incrementBalance(400);
		
		player.takeTurn(new LoadedDice(3));
		
		assertEquals (1900-190, player.getBalance());
	}

	@Test
	public void shouldPay200ForLandingOnIncomeTaxIfRich () {
		
		Player player = new Player(Token.Racecar, firstSquare);
		player.incrementBalance(1500);
		
		player.takeTurn(new LoadedDice(3));
		
		assertEquals (2800, player.getBalance());
	}
}
