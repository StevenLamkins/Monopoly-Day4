package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenInteractingWithGoSquare {

	Square firstSquare  = new GoSquare("Go");
	Square square2 = new Square("2");
	Square square3 = new Square("3");
	Square square4 = new Square("4");
	
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
	
	@Test
	public void shouldNotUpdateBalanceWhenInitiallyMovingOffGoSquare() {
		Player player = new Player (Token.Thimble, firstSquare);
		player.takeTurn(new LoadedDice(1));
		assertEquals (1500, player.getBalance());
	}
	
	@Test
	public void shouldUpdateWhenPassingGoDuringTurn () {
		Player player = new Player (Token.Thimble, firstSquare);
		player.takeTurn(new LoadedDice(5));
		assertEquals (1700, player.getBalance());
	}

}
