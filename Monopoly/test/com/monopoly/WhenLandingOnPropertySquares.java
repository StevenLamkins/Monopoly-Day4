package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnPropertySquares {

	@Test
	public void shouldPurchaseUnownedAndAffordableProperty() {
		Board board = new Board();
		Player visitor = new Player(Token.Iron, board.getStartSquare());
		PropertySquare property = (PropertySquare)board.getSquares().get(9);
		visitor.takeTurn(new LoadedDie(5), new LoadedDie(4));
		
		assertEquals(1400, visitor.getMoney());
		assertEquals(visitor, property.getOwner());		

	}
	@Test
	public void shouldNotPurchaseOwnedProperty() {
		Board board = new Board();
		Player owner = new Player(Token.Battleship, board.getStartSquare());
		Player visitor = new Player(Token.Iron, board.getStartSquare());
		PropertySquare property = (PropertySquare)board.getSquares().get(9);
		owner.takeTurn(new LoadedDie(5), new LoadedDie(4));
		visitor.takeTurn(new LoadedDie(5), new LoadedDie(4));
		
		assertEquals(1500, visitor.getMoney());
		assertNotEquals(visitor, property.getOwner());	
	}
	@Ignore
	@Test
	public void shouldNotPurchaseUnaffordableProperty() {
		
	}
	 
	@Test
	public void shouldPayRentForOwnedLot() {
		Board board = new Board();
		Player owner = new Player(Token.Battleship, board.getStartSquare());
		Player visitor = new Player(Token.Iron, board.getStartSquare());
		PropertySquare property = (PropertySquare)board.getSquares().get(9);
		owner.takeTurn(new LoadedDie(6), new LoadedDie(6));
		visitor.takeTurn(new LoadedDie(6), new LoadedDie(6));
		
		assertEquals(1491, visitor.getMoney());
		assertEquals(1409, owner.getMoney());
	}
	
	@Ignore 
	@Test
	public void shouldPayRentForOwnedRailroad() {
		fail("Not yet implemented");
	}

	@Ignore 
	@Test
	public void shouldPayRentForOwnedUtility() {
		Board board = new Board();
		Player owner = new Player(Token.Battleship, board.getStartSquare());
		Player visitor = new Player(Token.Iron, board.getStartSquare());
		PropertySquare property = (PropertySquare)board.getSquares().get(9);
		owner.takeTurn(new LoadedDie(6), new LoadedDie(6));
		visitor.takeTurn(new LoadedDie(6), new LoadedDie(6));
		
		assertEquals(1452, visitor.getMoney());
		assertEquals(14, owner.getMoney());
	}
}
