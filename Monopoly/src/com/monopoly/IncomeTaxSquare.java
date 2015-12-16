package com.monopoly;


public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare() {
		super("Income Tax Square");
	}
	
	@Override
	public void landOnBy(Player aPlayer) {
		
	    int	taxAmt = Math.min(aPlayer.getMoney()/10, 200);
	    aPlayer.debit(taxAmt);
	}
}
