package com.monopoly.squares;

import com.monopoly.Player;

public class IncomeTaxSquare extends Square{

	public IncomeTaxSquare(int position, String name) {
		super(position, name);
		// TODO Auto-generated constructor stub
	}
	
	public void landOn(Player player)
	{
		int money = player.getMoney();
		if(money * 0.1 < 200)
		{
			money = (int)Math.floor(money * 0.9);
		}
		else 
		{
			money = money - 200;
		}
		player.setMoney(money);
	}

}
