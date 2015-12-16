package com.monopoly;

public class LuxTaxSquare extends Square {

	public LuxTaxSquare() {
		super("Luxury Square");
		// TODO Auto-generated constructor stub
	}
	
@Override
public void landOnBy(Player aPlayer) {
	aPlayer.debit(75);
}

}
