package com.monopoly;

import static org.junit.Assert.*;

import org.junit.*;

public class WhenLandingOnPropertySquare {
	
	Square firstSquare  = new Square("First", 1);
	PropertySquare square2 = new LotSquare("Lot", 2);
	PropertySquare square3 = new LotSquare("Lot", 3);
	PropertySquare square4 = new UtilitySquare("4", 4);
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
	
	@Test
	public void shouldPayRentOnLotWhenLandingOnOwned () {
		player.takeTurn(new LoadedDice(2));
		
		Player player2 = new Player (Token.Battleship, firstSquare);
		player2.takeTurn(new LoadedDice(2));
		
		assertEquals (1500-30+3, player.getBalance());
		assertEquals (1500-3, player2.getBalance());
	}
	
	@Test
	public void shouldNotPayRentOnOwnProperty () {
		player.takeTurn (new LoadedDice(2));
		int balanceAfterPurchase = player.getBalance();
				
		player.takeTurn(new LoadedDice(4));
		assertEquals (balanceAfterPurchase, player.getBalance());
	}
	
	@Test
	public void shouldPayRentForOwnedUtility () {
		player.takeTurn(new LoadedDice(3));
		
		Player player2 = new Player (Token.Battleship, firstSquare);
		player2.takeTurn(new LoadedDice(3));
		
		assertEquals (1472, player.getBalance());
		assertEquals (1500-12, player2.getBalance());
	}

}
