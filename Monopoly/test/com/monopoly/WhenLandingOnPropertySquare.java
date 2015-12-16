package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dicegame.Die;

public class WhenLandingOnPropertySquare {

	@Test
	public void shouldBuyPropertyWhenHaveFundsAndNotOwned() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), 1);

		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		System.out.println(player.getSquare().getName() + " balance  "
				+ player.getAccountBalance());
		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(startingBalance - 60, player.getAccountBalance(), 0.001);
		assertEquals(player, ((PropertySquare) player.getSquare()).getOwner());

	}

	@Test
	public void notBuyPropertyThatIsOwned() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), 1);
		Player player2 = new Player(board.getSquares().get(0), 2);

		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		player2.takeTurn(dice);
		System.out.println(player.getSquare().getName() + " balance  "
				+ player.getAccountBalance());
		((PropertySquare) player.getSquare()).getPrice();

		assertNotEquals(player2,
				((PropertySquare) player.getSquare()).getOwner());
	}

	@Test
	public void playerDoesNotBuyPropertyCannotAfford() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), 1);

		player.debit(1490);
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		System.out.println(player.getSquare().getName() + " balance  "
				+ player.getAccountBalance());
		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(10, player.getAccountBalance(), 0.001);
		assertNotEquals(player,
				((PropertySquare) player.getSquare()).getOwner());
	}

	@Test
	public void playerShouldPaysRentToOwner() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), 1);
		Player player2 = new Player(board.getSquares().get(0), 2);

		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(4);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		player2.takeTurn(dice);
		System.out.println(player.getSquare().getName() + " balance  "
				+ player.getAccountBalance());
		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(1436, player.getAccountBalance(), 0.001);
		assertEquals(1494, player2.getAccountBalance(), 0.001);

	}
}
