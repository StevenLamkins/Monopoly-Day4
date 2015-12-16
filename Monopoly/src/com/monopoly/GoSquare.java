package com.monopoly;

public class GoSquare extends Square {
	
	private static final int SALARY_AMOUNT = 200;

	public GoSquare(String name) {
		super(name);
	}

	@Override
	public void landedOnBy(Player player) {
		//System.out.println("Landed on Go square");
		player.incrementBalance(SALARY_AMOUNT);		
	}

	@Override
	public void passedBy(Player player) {
		player.incrementBalance(SALARY_AMOUNT);
	}
}
