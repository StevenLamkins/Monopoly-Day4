package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenInteractingWithMoneySquares {
	
	private MonopolyGame game;
	private final int NUM_OF_PLAYERS = 4;
	private List<Player> players;
	private int previousBalance = 0;
	
	@Before
	public void setup ()
	{
		game = new MonopolyGame(NUM_OF_PLAYERS);
		players = game.getNumberOfPlayers();
		game.playRound();
	}
	
	@Ignore
	@Test
	public void shouldCollect200ForLandingOnGo() {
		
		//Set player location
		players.get(0).setLocation(38);
		//Force the die roll to equal 2 and play from there
		players.get(0).move(2); 
				
		int playerBalance = players.get(0).getMoney();
		
		
		//Should be 1700
		assertEquals(1700, playerBalance);
	}
	
	@Ignore
	@Test
	public void shouldPay75ForLandingOnLuxuryTax() {
		previousBalance = players.get(0).getMoney();
		
		//Set player location
		players.get(0).setLocation(35);
		//Force the die roll to equal 3 and play from there
		players.get(0).move(3); 
				
		int playerBalance = players.get(0).getMoney();
		
		
		//Should be 75
		assertEquals(75 , (previousBalance - playerBalance) );
	}	

	@Ignore
	@Test
	public void shouldSubtract200WhenLandingOnIncomeTaxWithOver3000() {
		players.get(0).setMoney(3000);	
		//Set player location
		players.get(0).setLocation(0);
		//Force the die roll to equal 3 and play from there
		players.get(0).move(4);
		
		int playerBalance = players.get(0).getMoney();
		
		//Should be 2800
		assertEquals(2800 , playerBalance);
	}
	
	@Ignore
	@Test
	public void shouldSubtract10PercentWhenLandingOnIncomeTaxWithUnder2000() {
		players.get(0).setMoney(1500);	
		//Set player location
		players.get(0).setLocation(0);
		//Force the die roll to equal 3 and play from there
		players.get(0).move(4);
		
		int playerBalance = players.get(0).getMoney();
		
		//Should be 1350
		assertEquals(1350 , playerBalance);
	}
	
	@Ignore
	@Test
	public void shouldCollect200ForPassingGo() {
		//Set player location
		players.get(0).setLocation(38);
		//Force the die roll to equal 2 and play from there
		players.get(0).move(4); 
				
		int playerBalance = players.get(0).getMoney();		
		
		//Should be 1700
		assertEquals(1700, playerBalance);
	}
}

