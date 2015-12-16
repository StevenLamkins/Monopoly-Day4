package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenInteractingWithGoSquare {

	Square firstSquare  = new GoSquare();
	Square square2 = new Square();
	Square square3 = new Square();
	Square square4 = new Square();
	
	@Before
	public void setupSquares() {
		firstSquare.setNext(square2);
		square2.setNext(square3);
		square3.setNext(square4);
		square4.setNext(firstSquare);
	}

	@Test
	public void shouldUpdatePlayerBalanceLandingOnGo() {
		Player player = new Player(Token.Battleship, firstSquare);
		player.takeTurn(new LoadedDice(4));
		assertEquals (1700, player.getBalance());
	}

}
