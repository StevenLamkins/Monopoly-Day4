package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenLandingOnTaxSquares {
	
	Square firstSquare  = new Square();
	Square square2 = new Square();
	Square square3 = new LuxuryTaxSquare();
	Square square4 = new Square();
	
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

}
