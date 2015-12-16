package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnProperty {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldBuyPropertyUnownedAndAffordable() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(27), Token.BATTLESHIP);
		testPlayer.takeTurn(new LoadedDie(2));
		
		PropSquare prop = (PropSquare)testPlayer.getLocation();
		assertTrue(prop.isOwned());
	}
	
	
	@Test
	public void shouldNotBuyPropertyThatIsOwned() {
		Board board = new Board();
		Player testPlayer1 = new Player(board.getSquares().get(27), Token.BATTLESHIP);
		testPlayer1.takeTurn(new LoadedDie(2));
		
		Player testPlayer2 = new Player(board.getSquares().get(27), Token.BOOT);
		testPlayer2.takeTurn(new LoadedDie(2));
		
		PropSquare prop = (PropSquare)testPlayer2.getLocation();
		//System.out.println("Is owned: " + prop.isOwned() );
		//System.out.println("Is owned: " + prop.getOwner().getToken());
		assertTrue(prop.isOwned());
	}
	
	@Test
	public void shouldNotBuyPropertyThatIsNotAffordable() {
		Board board = new Board();
		Player testPlayer = new Player(board.getSquares().get(27), Token.BATTLESHIP);
		testPlayer.debit(1300);
		
		testPlayer.takeTurn(new LoadedDie(2));
		
		PropSquare prop = (PropSquare)testPlayer.getLocation();
		//System.out.println("Is owned: " + prop.isOwned() );
		//System.out.println("Ownwer: " + prop.getOwner().getToken());
		assertFalse(prop.isOwned());
	}

}
