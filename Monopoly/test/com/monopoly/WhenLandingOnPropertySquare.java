package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dicegame.Die;

public class WhenLandingOnPropertySquare {

	@Test
	public void shouldBuyPropertyWhenHaveFunds() {
		Board board = new Board();	

		Player player = new Player(board.getSquares().get(0), 1);

		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName() + " balance  " + player.getAccountBalance());
  		((PropertySquare)player.getSquare()).getPrice();
		
  		assertEquals(startingBalance - 60, player.getAccountBalance(), 0.001);
  		assertEquals(player, ((PropertySquare)player.getSquare()).getOwner());

	}

}
