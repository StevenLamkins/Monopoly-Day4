package com.monopoly;

public class LuxuryTaxSquare extends Square {
	
	private static final int LUXURY_TAX_AMOUNT = 75;

	public LuxuryTaxSquare(String name, int squareNumber) {
		super(name, squareNumber);
	}

	@Override
	public void landedOnBy(Player player) {
		//System.out.println("Landed on Luxury Tax square");
		player.decrementBalance(LUXURY_TAX_AMOUNT);
	}

}
