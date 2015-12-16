package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class WhenRunningTheGame {

	@Test
	public void shouldAllowPlayerToMove() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);		
		int numSpaces = p.takeTurn(game.getDieOne(), game.getDieTwo());
		
		assertTrue(numSpaces > 0);
	}
	
	@Test
	public void shouldAllowAllPlayersToLeaveGo() {
		MonopolyGame game = new MonopolyGame(8);
		
		for (Player p : game.getPlayers()) {
			Square startPos = game.getPlayerSquare(p);
			p.takeTurn(game.getDieOne(), game.getDieTwo());
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
		p.takeTurn(new LoadedDie(6), new LoadedDie(6));
		
		assertNotEquals(Square.ElectricCompany, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldMoveCorrectNumberOfSquares() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int numMoved = p.takeTurn(game.getDieOne(), game.getDieTwo());
		
		assertEquals(game.getBoard().getSquareAt(numMoved), game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldMoveCorrectNumberOfSquaresAfterDoubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int numMoved = p.takeTurn(new LoadedDie(6), new LoadedDie(6), true);
		numMoved += p.takeTurn(game.getDieOne(), game.getDieTwo());
		
		assertEquals(game.getBoard().getSquareAt(numMoved), game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToCircleTheBoard() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(20), new LoadedDie(21));
		
		assertEquals(Square.MediterraneanAvenue, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGoToJail() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(20), new LoadedDie(10));
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldGoToJailAfter3Doubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(2), new LoadedDie(2), true);
		p.takeTurn(new LoadedDie(4), new LoadedDie(4), true);
		p.takeTurn(new LoadedDie(6), new LoadedDie(6), true);
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGetOutOfJailWithDoubles() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(20), new LoadedDie(10));
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
		
		p.takeTurn(new LoadedDie(6), new LoadedDie(6), true);
		p.takeTurn(new LoadedDie(1), new LoadedDie(3));
		
		assertEquals(Square.VirginiaAvenue, game.getPlayerSquare(p));
	}
	
	@Test
	public void shouldBeAbleToGetOutOfJailByTimeout() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(20), new LoadedDie(10));
		
		assertEquals(Square.Jail, game.getPlayerSquare(p));
		
		int startBal = p.getBalance();
		
		p.takeTurn(new LoadedDie(1), new LoadedDie(2));
		p.takeTurn(new LoadedDie(1), new LoadedDie(2));
		p.takeTurn(new LoadedDie(1), new LoadedDie(2));
		p.takeTurn(new LoadedDie(1), new LoadedDie(3));
		
		int endBal = p.getBalance();
		
		assertEquals(Square.VirginiaAvenue, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
	}
	
	@Test
	public void shouldPay10PercentIncomeTax() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int startBal = p.getBalance();
		p.takeTurn(new LoadedDie(1), new LoadedDie(3));
		int endBal = p.getBalance();
		
		assertEquals(Square.IncomeTax, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
		assertEquals(startBal-endBal, 150);
	}

	@Test
	public void shouldPayMaxIncomeTax() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		p.deposit(1500);
		int startBal = p.getBalance();
		p.takeTurn(new LoadedDie(1), new LoadedDie(3));
		int endBal = p.getBalance();
		
		assertEquals(Square.IncomeTax, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
		assertEquals(startBal-endBal, 200);
	}
	
	@Test
	public void shouldPayLuxuryTax() {
		MonopolyGame game = new MonopolyGame(2);
		
		Player p = game.getPlayers().get(0);
		int startBal = p.getBalance();
		p.takeTurn(new LoadedDie(30), new LoadedDie(8));
		int endBal = p.getBalance();
		
		assertEquals(Square.LuxuryTax, game.getPlayerSquare(p));
		assertNotEquals(startBal, endBal);
		assertEquals(startBal-endBal, 75);
	}
	
	@Test
	public void shouldBeAbleToBuyProperty() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		p.takeTurn(new LoadedDie(1), new LoadedDie(2));
		
		assertEquals(p, game.getSquareOwner(Square.BalticAvenue));
	}
	
	@Test
	public void shouldPayRentOnAnotherPlayersSquare() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p1 = game.getPlayers().get(0);
		p1.takeTurn(new LoadedDie(1), new LoadedDie(2));
		
		Player p2 = game.getPlayers().get(1);
		int startBal = p2.getBalance();
		p2.takeTurn(new LoadedDie(1), new LoadedDie(2));
		int endBal = p2.getBalance();
		
		assertEquals(p1, game.getSquareOwner(Square.BalticAvenue));
		assertEquals(startBal-endBal, Square.BalticAvenue.getRent());
	}
	
	@Test
	public void shouldDoNothingOnFreeParking() {
		MonopolyGame game = new MonopolyGame(2, false);
		
		Player p = game.getPlayers().get(0);
		int startBal = p.getBalance();
		p.takeTurn(new LoadedDie(18), new LoadedDie(2));
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
		p.takeTurn(new LoadedDie(1), new LoadedDie(1)); //Extra turn to buy at the start of
		
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
