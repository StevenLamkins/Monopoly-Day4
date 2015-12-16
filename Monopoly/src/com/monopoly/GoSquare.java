package com.monopoly;

public class GoSquare extends Square {
	
	public GoSquare() {
	
	}

	//When the player lands on the go square, take the player object and add $200 to their current balance
	@Override
	public void landOn(Player player)
	{
		int currentBalance;
		 
		currentBalance = player.getMoney();
		player.setMoney(currentBalance + 200);	
		player.setEarned200(true);
		}
	
	@Override
	public void passOverBy(Player player) {
		int currentBalance;
		 
		currentBalance = player.getMoney();
		player.setMoney(currentBalance + 200);	
		player.setEarned200(true);
	}
	
}
