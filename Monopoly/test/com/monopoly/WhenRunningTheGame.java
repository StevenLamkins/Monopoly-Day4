package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WhenRunningTheGame {

	@Test
	public void shouldAllowPlayerToMove() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int start = p.getPosition();
		
		int numSpaces = game.takeTurn(p);
		
		int end = p.getPosition();
		
		assertTrue(numSpaces > 0);
	}
	
	@Test
	public void shouldAllowAllPlayersToLeaveGo() {
		MonopolyGame game = new MonopolyGame(8);
		
		for (Player p : game.getPlayers()) {
			Square startPos = game.getPlayerSquare(p);
			game.takeTurn(p);
			Square endPos = game.getPlayerSquare(p);
			
			assertNotEquals(startPos, endPos);
			assertNotEquals(Square.Go, endPos);
		}
	}
	
	@Test
	public void shouldAllowGameToEnd() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.withdraw(p.getBalance());
		
		try {
			game.start();
		} catch (Exception e) {
			fail("Game failed to end!");
		}
	}
	
	@Test
	public void shouldBeAbleToMoveAgainAfterDoubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 6, 6);
		
		assertNotEquals(Square.ElectricCompany, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldMoveCorrectNumberOfSquares() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int numMoved = game.takeTurn(p);
		
		assertEquals(game.getBoard().getSquareAt(numMoved), game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldMoveCorrectNumberOfSquaresAfterDoubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int numMoved = game.takeTurn(p, 6, 6);
		numMoved += game.takeTurn(p);
		
		assertEquals(game.getBoard().getSquareAt(numMoved), game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToCircleTheBoard() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 20, 21);
		
		assertEquals(Square.MediterraneanAvenue, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGoToJail() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 20, 10, true);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldGoToJailAfter3Doubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 2, 2, true);
		game.takeTurn(p, 4, 4, true);
		game.takeTurn(p, 6, 6, true);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGetOutOfJailWithDoubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 20, 10);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
		
		game.takeTurn(p, 6, 6, true);
		game.takeTurn(p, 1, 3);
		
		assertEquals(Square.VirginiaAvenue, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGetOutOfJailByTimeout() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 20, 10);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
		
		int startBal = p.getBalance();
		
		game.takeTurn(p, 1, 2);
		game.takeTurn(p, 1, 2);
		game.takeTurn(p, 1, 2);
		game.takeTurn(p, 1, 3);
		
		int endBal = p.getBalance();
		
		assertEquals(Square.VirginiaAvenue, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
	}
	
	@Test
	public void shouldPayTaxes() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int startBal = p.getBalance();
		game.takeTurn(p, 1, 3);
		int endBal = p.getBalance();
		
		assertEquals(Square.IncomeTax, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
	}
	
	@Test
	public void shouldBeAbleToBuyProperty() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		game.takeTurn(p, 1, 2);
		
		assertEquals(p, game.getSquareOwner(Square.BalticAvenue));
	}
	
	@Test
	public void shouldDoNothingOnFreeParking() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		int startBal = p.getBalance();
		game.takeTurn(p, 18, 2);
		int endBal = p.getBalance();
		
		assertEquals(startBal, endBal);
		assertEquals(Square.FreeParking, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBuyHouseWithMonopoly() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		game.giveSquareToPlayer(p, Square.OrientalAvenue);
		game.giveSquareToPlayer(p, Square.VermontAvenue);
		game.giveSquareToPlayer(p, Square.ConnecticutAvenue);
		game.takeTurn(p, 1, 1); //Extra turn to buy at the start of
		
		//assertTrue(); //Should have 1 house (if could afford)
		
	}
	
	@Test
	public void shouldBeAbleToDetectMonopolies() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		game.giveSquareToPlayer(p, Square.OrientalAvenue);
		game.giveSquareToPlayer(p, Square.SaintCharlesPlace);
		game.giveSquareToPlayer(p, Square.StatesAvenue);
		game.giveSquareToPlayer(p, Square.ConnecticutAvenue);
		game.giveSquareToPlayer(p, Square.VirginiaAvenue);
		game.giveSquareToPlayer(p, Square.VermontAvenue);
		game.giveSquareToPlayer(p, Square.SaintJamesPlace);
		
		List<SquareGroup> monopolies = Square.getMonopolies(p.getProperties());
		assertTrue(monopolies.contains(SquareGroup.LIGHT_GREEN));
		assertTrue(monopolies.contains(SquareGroup.VIOLET));
		assertFalse(monopolies.contains(SquareGroup.ORANGE));
	}

}
