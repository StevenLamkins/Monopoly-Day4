package com.monopoly;

public class IncomeTaxSquare extends Square {
	
	private static final int RICH_GUY_INCOME_TAX = 200;
	private static final double INCOME_TAX_PERCENT = 0.10;
	private static final int INCOME_TAX_THRESHOLD = 2000;

	public IncomeTaxSquare(String name) {
		super(name);
	}

	@Override
	public void landedOnBy (Player player) {
		
		int playerBalance = player.getBalance();
		
		if (playerBalance < INCOME_TAX_THRESHOLD) {
			player.decrementBalance((int)(playerBalance * INCOME_TAX_PERCENT));
		} else {
			player.decrementBalance(RICH_GUY_INCOME_TAX);
		}
	}

}
