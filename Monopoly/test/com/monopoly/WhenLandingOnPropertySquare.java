package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnPropertySquare {
	
	Square firstSquare  = new GoSquare("First", 1);
	PropertySquare square2 = new PropertySquare("Property", 2);
	Square square3 = new Square("3", 3);
	Square square4 = new Square("4", 4);
	Player player = new Player (Token.Wheelbarrow, firstSquare);
	
	@Before
	public void setupSquares() {
		firstSquare.setNext(square2);
		square2.setNext(square3);
		square3.setNext(square4);
		square4.setNext(firstSquare);
	}

	@Test
	public void shouldBuyThePropertyIfCanAffordIt() {
		player.takeTurn(new LoadedDice(1));
		assertSame(player, square2.getOwner());
		assertNotEquals (square2.getPrice(), 0);
		assertEquals (1500-player.getBalance(), square2.getPrice());
	}
	
	@Test
	public void shouldNotBuyPropertyIfCannotAffordIt () {
		player.decrementBalance(1499);
		player.takeTurn (new LoadedDice(1));
		assertNull (square2.getOwner());
		assertEquals (1, player.getBalance());
	}
	
	@Test
	public void shouldNotBuyPropertyIfAlreadyOwned () {
		Player player2 = new Player (Token.Battleship, firstSquare);
		player2.takeTurn(new LoadedDice(1));
		
		player.takeTurn(new LoadedDice(1));
		assertSame(square2.getOwner(), player2);
	}

}
