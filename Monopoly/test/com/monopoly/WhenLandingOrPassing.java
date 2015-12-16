package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenLandingOrPassing {
	private MonopolyGame game;
	Player player;
	
	@Before
	public void setup()
	{
		game = new MonopolyGame(2);
		player = game.getPlayers().get(0);
	}
	
	
	@Test
	public void landOnGoGet200() {
		player.move(40);
		assertEquals(1700, player.getMoney());
	}
	
	
	@Test
	public void landOnLuxTaxMinus75() {
		player.move(38);
		assertEquals(1425, player.getMoney());
	}
	
	
	@Test
	public void landOnIncomeTaxPoor() {
		Player player2 = new Player(0,game.getSquares().get(0));
		player2.move(4);
		assertEquals(1350, player2.getMoney());
	}
	
	
	@Test
	public void landOnIncomeTaxRich() {
		Player player2 = new Player(0,game.getSquares().get(0));
		player2.addMoney(1500);
		player2.move(4);
		assertEquals(2800, player2.getMoney());
	}
	
	
	@Test
	public void passOverGoBalancePlus200() {
		Player player2 = new Player(0,game.getSquares().get(30));
		player2.move(12);
		assertEquals(1700, player2.getMoney());
	}

}
