package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOnGoOrPayingTaxes {

	@Test
	public void shouldIncreaseBalanceBy200OnGo() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(20);
		Die d2 = new LoadedDie(20);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(player.getBalance(), 1700);
	}

	@Test
	public void shouldDecreaseBalanceBy75OnLuxuryTax() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(20);
		Die d2 = new LoadedDie(18);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(1425, player.getBalance());
	}

	@Test
	public void shouldDecreaseBalanceBy200OnIncomeTaxWith3000Balance() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		player.setBalance(3000);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(2);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(2800, player.getBalance());
	}

	@Test
	public void shouldDecreaseBalanceBy150OnIncomeTaxWith1500Balance() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		player.setBalance(1500);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(2);
		Die d2 = new LoadedDie(2);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(1350, player.getBalance());
	}

	@Test
	public void shouldIncreaseBalanceBy200PassingGo() {
		MonopolyGame game = new MonopolyGame();
		Player player = game.getPlayers().get(0);
		player.setBalance(1500);
		List<Die> dice = new ArrayList<>();
		Die d1 = new LoadedDie(21);
		Die d2 = new LoadedDie(21);
		dice.add(d1);
		dice.add(d2);
		player.takeTurn(dice,game.getBoard());
		assertEquals(1700, player.getBalance());
	}

}
