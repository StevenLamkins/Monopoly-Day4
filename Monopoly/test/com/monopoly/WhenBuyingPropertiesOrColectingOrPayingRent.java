package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.monopoly.squares.LotSquare;

public class WhenBuyingPropertiesOrColectingOrPayingRent {

	@Test
	public void shouldBuyPropertyThatIsUnownedAndAffordable() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(1);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(1440, player.getBalance());
		assertSame(player.getLocation(), player.getDeeds().get(0));
		assertSame(player, ((LotSquare)player.getLocation()).getOwner());
	}

	@Test
	public void shouldNotBuyPropertyThatIsOwned() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(1);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
        Player player2 = game.getPlayers().get(1);
		player2.takeTurn(dice,game.getBoard());
		assertEquals(1496, player2.getBalance());
		assertNotSame(player2, ((LotSquare)player2.getLocation()).getOwner());
	}

	@Test
	public void shouldNotBuyPropertyThatIsUnaffordable() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(1);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.setBalance(10);
		player.takeTurn(dice,game.getBoard());
		assertEquals(10, player.getBalance());
		assertNotSame(player, ((LotSquare)player.getLocation()).getOwner());
	}

	@Test
	public void shouldPayRentFromVisitorToOwner() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(1);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
        Player player2 = game.getPlayers().get(1);
		player2.takeTurn(dice,game.getBoard());
		assertEquals(1444, player.getBalance());
		assertEquals(1496, player2.getBalance());
	}

	@Test
	public void shouldNotPayRentForOwnProperty() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(1);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		Die d3 = new LoadedDie(20);
		Die d4 = new LoadedDie(20);
		dice.clear();
		dice.add(d3);
		dice.add(d4);
		player.takeTurn(dice,game.getBoard());
		assertEquals(1640, player.getBalance());
	}

	@Test
	public void shouldPay50ForRailroadRent() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(2);
		Die d2 = new LoadedDie(3);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
        Player player2 = game.getPlayers().get(1);
		player2.takeTurn(dice,game.getBoard());
		assertEquals(1350, player.getBalance());
		assertEquals(1450, player2.getBalance());
	}

	@Test
	public void shouldPayRollTimes4UtilityRent() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(6);
		Die d2 = new LoadedDie(6);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
        Player player2 = game.getPlayers().get(1);
		player2.takeTurn(dice,game.getBoard());
		assertEquals(1398, player.getBalance());
		assertEquals(1452, player2.getBalance());
	}

}
