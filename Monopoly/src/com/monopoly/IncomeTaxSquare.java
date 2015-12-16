package com.monopoly;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(int position) {
		super(position,"INCOME TAX");
	}
	
	
	public void action(Player player)
	{
		int playerMoney = (int) (player.getMoney() * .1);
		
		if(playerMoney > 200)
		{
			player.addMoney(-200);
		}
		else
		{
			player.addMoney(-1 * playerMoney);
		}
		
	}

}
