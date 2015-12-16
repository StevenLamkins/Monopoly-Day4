package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WhenPlayingTheGame {
	
	@Test
	public void playerShouldMoveWhenRollingDice() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Square startSquare = currentPlayer.getSquare();
		Die die = new Die(6, 2, false);
		currentPlayer.takeTurn(die, false);
		assertNotEquals(startSquare, currentPlayer.getSquare());
	}
	
	@Test
	public void gameShouldAllowSpaceJumping() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		currentPlayer.moveToSquare("free parking", false);
		assertEquals(currentPlayer.getSquare().getId(), "free parking");
	}
	
	@Test
	public void gameShouldReward200AfterPassingGo() {
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 21, false);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getMoney(), 1700);
	}
	
	@Test
	public void gameShouldSendPlayerToJailAfterDoubles(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 3, true);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
	}
	
	@Test
	public void gameShouldAllowPlayerToLeaveJailAfterDoubles(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 3, true);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
		currentPlayer.takeTurn(die, false);
		assertNotEquals(currentPlayer.getSquare().getId(), "jail");
	}
	
	@Test
	public void gameNeeds3NonDoublesToEscapeJail(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 1, true);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
		die = new Die(6, 1, false);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.isInJail(), false);
		assertEquals(currentPlayer.getMoney(), 1450);
	}
	
	@Test
	public void gameShouldAllowPlayerToLeaveJailWithCard(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 3, true);
		currentPlayer.takeTurn(die, false);
		assertEquals(currentPlayer.getSquare().getId(), "jail");
		currentPlayer.addOutOfJailCard();
		die = new Die(6, 3, false);
		currentPlayer.takeTurn(die, false);
		assertNotEquals(currentPlayer.getSquare().getId(), "jail");
		assertEquals(currentPlayer.getMoney(), 1500);
	}
	
	@Test
	public void gameShouldAllowPlayerToBuyProperty(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		Die die = new Die(6, 1, false);
		currentPlayer.takeTurn(die, true);
		assertEquals(currentPlayer.getMoney(), 1440);
		assertEquals(currentPlayer.getSquare().getSquareType(),"PROPERTY");
		assertEquals(currentPlayer.getSquare().getOwner(),currentPlayer);
	}
	
	@Test
	public void gameShouldAllowPlayerToBuyHouses(){
		MonopolyGame game = new MonopolyGame(4);
		List<Player> players = game.getPlayers();
		Player currentPlayer = players.get(0);
		currentPlayer.moveToSquare("mediteranian avenue", true);
		currentPlayer.moveToSquare("baltic avenue", true);
		assertTrue(currentPlayer.ownedProperties.size()==2);
		assertTrue(currentPlayer.ownedGroups.get("purple")==2);
		assertTrue(((Property)currentPlayer.getSquare()).isPremiumProperty);
		assertTrue(((Property)currentPlayer.getSquare()).houseCount==1);
	}

}
