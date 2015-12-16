package com.monopoly;

public class IncomeTaxSquare extends Square {
	
	private static final double INCOME_TAX_PERCENT = 0.10;
	private static final int INCOME_TAX_THRESHOLD = 200;

	public IncomeTaxSquare(String name, int squareNumber) {
		super(name, squareNumber);
	}

	@Override
	public void landedOnBy (Player player) {
		
		int playerBalance = player.getBalance();
		
		int taxAmount = (int)(playerBalance * INCOME_TAX_PERCENT);
		if (taxAmount > INCOME_TAX_THRESHOLD) taxAmount = INCOME_TAX_THRESHOLD;
		player.decrementBalance(taxAmount);
	}

}
