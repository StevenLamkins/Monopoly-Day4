package com.monopoly;

public class GoSquare extends Square {
	
	private static final int SALARY_AMOUNT = 200;

	public void landedOnBy(Player player) {
		player.incrementBalance(SALARY_AMOUNT);		
	}

}
