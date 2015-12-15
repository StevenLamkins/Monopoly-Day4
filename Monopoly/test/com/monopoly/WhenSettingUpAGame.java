package com.monopoly;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.monopoly.MonopolyGame;

import static org.junit.Assert.*;



public class WhenSettingUpAGame {

	@Test
	public void shouldHave40Squares() {
		//setup + exercise
		
		MonopolyGame game = new MonopolyGame(4);
		List<Space> space = game.getSpaces();
		
		//verify
		assertEquals(40, space.size());
	}
	
	@Test
	public void shouldHaveUniqueSpaceName(){

	}
	
	@Test
	public void shouldHaveAtLeast2Players() {
		
		//setup + exercise
		MonopolyGame game = new MonopolyGame(4);
		List<Player> player = game.getPlayers();
		
		//verify
		assertTrue("At Least 2 Players", player.size() > 2);
	}
	
	@Test
	public void shouldErrorWhenLessThan2Player() {
		//setup + exercise
		MonopolyGame game;
		try {
			game = new MonopolyGame(1);
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test 	
	public void shouldErrorWhenMoreThan8Player() {
		//setup + exercise
		MonopolyGame game;
		try {
			game = new MonopolyGame(9);
			fail();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
	
	@Ignore
	@Test
	public void shouldHaveUniqueToken() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHaveTwoDie() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void shouldHave1500InMoney() {
		fail("Not yet implemented");
	}
}
