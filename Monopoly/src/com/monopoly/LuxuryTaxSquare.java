package com.monopoly;

public class LuxuryTaxSquare extends Square {
	public LuxuryTaxSquare() {

	}
	
	//When landed on, subtract 75
	@Override
	public void landOn(Player player)
	{
		int currentBalance; 
		int tax = -75;
		
		currentBalance = player.getMoney();
		player.setMoney(currentBalance + tax);
	}
}
