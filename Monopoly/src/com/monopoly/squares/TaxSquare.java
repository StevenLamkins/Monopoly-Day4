package com.monopoly.squares;

import com.monopoly.Player;

public class TaxSquare extends Square {
	private int taxValue;

	public TaxSquare(int index) {
		super(index);
		taxValue = 75;
	}

	public int landOnBy(Player player) {
		taxValue = rents[position];
		if (taxValue < 0) {
			taxValue = (int) Math.min(player.getBalance()*0.1,200);
		}
		return taxValue;
	}

	public int getRent() {
		return taxValue;
	}	
	
}
