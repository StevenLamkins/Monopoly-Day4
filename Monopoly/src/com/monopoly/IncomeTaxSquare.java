package com.monopoly;

public class IncomeTaxSquare extends Square {
	public IncomeTaxSquare() {
	
	}
	
	//When landed on, subtract 200 or 10% - whichever is lesser
	@Override
	public void landOn(Player player)
	{
		int currentBalance;
		int tax = 0;
		 
		currentBalance = player.getMoney();
		if(currentBalance >= 2000)
		{
			tax = 200;
		}
		else if (currentBalance < 2000)
		{
			tax = (int) (currentBalance * 0.1);
		}
		
		player.setMoney(currentBalance - tax);
	}
}
