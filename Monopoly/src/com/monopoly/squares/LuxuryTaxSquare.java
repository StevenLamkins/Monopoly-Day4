package com.monopoly.squares;

import com.monopoly.Player;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(int position, String name) {
		super(position, name);
		// TODO Auto-generated constructor stub
	}

	public void landOn(Player player)
	{
		player.setMoney(player.getMoney() - 75);
	}
}
