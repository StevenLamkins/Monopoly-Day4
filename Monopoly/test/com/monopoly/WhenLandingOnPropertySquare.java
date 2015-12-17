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

		Player player = new Player(board.getSquares().get(0), Token.WheelBarrel);

		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(startingBalance - 40, player.getAccountBalance(), 0.001);
		assertEquals(player, ((PropertySquare) player.getSquare()).getOwner());

	}

	@Test
	public void notBuyPropertyThatIsOwned() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), Token.BattleShip);
		Player player2 = new Player(board.getSquares().get(0), Token.Dog);

		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		player2.takeTurn(dice);

		((PropertySquare) player.getSquare()).getPrice();

		assertNotEquals(player2,
				((PropertySquare) player.getSquare()).getOwner());
	}

	@Test
	public void playerDoesNotBuyPropertyCannotAfford() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), Token.Hat);

		player.debit(1490);
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);

		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(10, player.getAccountBalance(), 0.001);
		assertNotEquals(player,
				((PropertySquare) player.getSquare()).getOwner());
	}

	@Test
	public void playerShouldPaysRentToOwner() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), Token.Iron);
		Player player2 = new Player(board.getSquares().get(0), Token.RaceCar);

		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(4);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		player2.takeTurn(dice);

		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(1436, player.getAccountBalance(), 0.001);
		assertEquals(1494, player2.getAccountBalance(), 0.001);

	}
	
	@Test
	public void playerShouldPayRentToOwnerForRailRoad() {
		Board board = new Board();

		Player player = new Player(board.getSquares().get(0), Token.Shoe);
		Player player2 = new Player(board.getSquares().get(0), Token.Thimble);

		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(3);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
		player.takeTurn(dice);
		player2.takeTurn(dice);

		((PropertySquare) player.getSquare()).getPrice();

		assertEquals(1325, player.getAccountBalance(), 0.001);
		assertEquals(1475, player2.getAccountBalance(), 0.001);

	}
}
