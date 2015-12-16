package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenLandingOrPassingMoneySquares {

	MonopolyGame game;
	
	@Before
	public void setUp() throws Exception {
		//setup
		game = new MonopolyGame(4);
	}

	
	@Test
	public void landOnGo() {
		Player player = game.getPlayers().get(0);
		player.move(40);
		int newMoney = player.getMoney();
		
		assertEquals(1700, newMoney);
	}
	
	@Test
	public void passGo() {
		Player player = game.getPlayers().get(0);
		player.move(50);
		int newMoney = player.getMoney();
		
		assertEquals(1700, newMoney);
	}

	@Test
	public void leavingGoFromGameStart() {
		Player player = game.getPlayers().get(0);
		player.move(10);
		int newMoney = player.getMoney();
		
		assertEquals(1500, newMoney);
	}
	
	@Test
	public void landOnLuxuryTax() {
		Player player = game.getPlayers().get(0);
		player.move(38);
		int newMoney = player.getMoney();
		
		assertEquals(1425, newMoney);
	}
	
	@Test
	public void landOnIncomeTaxPoor() {
		Player player = game.getPlayers().get(0);
		player.move(4);
		int newMoney = player.getMoney();
		
		assertEquals(1350, newMoney);
	}
	
	@Test
	public void landOnIncomeTaxRich() {
		Player player = game.getPlayers().get(0);
		player.setMoney(2000);
		player.move(4);
		int newMoney = player.getMoney();
		
		assertEquals(1800, newMoney);
	}
}
