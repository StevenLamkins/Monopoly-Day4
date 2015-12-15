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
		
		MonopolyGame game = new MonopolyGame();
		List<Space> space = game.getSpace();
		
		//verify
		assertEquals(40, space.size());
	}
	
	@Test
	public void shouldHaveAtLeast2Players() {
		
		//setup + exercise
		MonopolyGame game = new MonopolyGame();
		List<Player> player = game.getPlayers();
		
		//verify
		assertTrue("At Least 2 Players", player.size() > 2);
	}
	
	@Ignore
	@Test
	public void shouldErrorWhenStartPointIsNotGo() {
		fail("Not yet implemented");
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
