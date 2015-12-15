package com.monopoly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingAroundBoard {

	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	@Test
	public void diceRollInRange() {
		fail("Not yet implemented");
		// TO DO: Confirm can roll dice pair (who/what - player? game? board?), 
		//   with sum between 2 and 12 
	}

	@Ignore
	@Test
	public void playerMovesAfterRoll() {
		fail("Not yet implemented");
		// TO DO: Confirm a player advances to the right square after a dice roll 
	}
	
	@Ignore
	@Test
	public void playerPositionWrapsPastGo() {
		fail("Not yet implemented");
		// TO DO: Confirm a player's square position wraps around to start after passing "Go"
	}
}
