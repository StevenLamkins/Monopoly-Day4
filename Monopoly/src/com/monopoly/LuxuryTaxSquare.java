package com.monopoly;

public class LuxuryTaxSquare extends Square {
	
	private static final int LUXURY_TAX_AMOUNT = 75;

	public void landedOnBy(Player player) {
		player.decrementBalance(LUXURY_TAX_AMOUNT);
	}

}
