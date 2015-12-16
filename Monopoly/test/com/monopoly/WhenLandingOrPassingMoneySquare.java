package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dicegame.Die;

public class WhenLandingOrPassingMoneySquare {

	@Test
	public void shouldCollect200LandingOnGo() {

		Board board = new Board();	

		Player player = new Player(board.getSquares().get(38), 1);
		Die die1 = new LoadedDie(1);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName());
		
		assertEquals(1700.0, player.getAccountBalance(), 0.001);
	}
	
	@Test
	public void shouldPay75LandingOnLuxTax() {

		Board board = new Board();	

		Player player = new Player(board.getSquares().get(35), 1);
		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(1);
		Die die2 = new LoadedDie(2);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName() + " balance  " + player.getAccountBalance());
		
  		assertEquals(startingBalance -75.0, player.getAccountBalance(), 0.001);

	}
	
	@Test
	public void shouldPay200TaxWhenLandingOnIncomeTaxWithMoreThan2000Balance() {

		Board board = new Board();	

		Player player = new Player(board.getSquares().get(1), 1);
		player.incrementAccount(500);
		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName() + " balance  " + player.getAccountBalance());
		
  		assertEquals(startingBalance - 200, player.getAccountBalance(), 0.001);

	}	
	
	@Test
	public void shouldPay10PercentTaxWhenLandingOnIncomeTaxWithLessThan2000Balance() {

		Board board = new Board();	

		Player player = new Player(board.getSquares().get(1), 1);
		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(1);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName() + " balance  " + player.getAccountBalance());
		
  		assertEquals(startingBalance - 150, player.getAccountBalance(), 0.001);
	}
	
	@Test
	public void shouldCollect200WhenPassingGoSquare() {
		Board board = new Board();
		
		Player player = new Player(board.getSquares().get(35), 1);
		double startingBalance = player.getAccountBalance();
		Die die1 = new LoadedDie(2);
		Die die2 = new LoadedDie(5);
		List<Die> dice = new ArrayList<>();
		dice.add(die1);
		dice.add(die2);
  		player.takeTurn(dice);
  		System.out.println(player.getSquare().getName() + " balance  " + player.getAccountBalance());
		
  		assertEquals(startingBalance + 200, player.getAccountBalance(), 0.001);
	}

}
