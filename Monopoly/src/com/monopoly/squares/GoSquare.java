package com.monopoly.squares;

import com.monopoly.Player;

public class GoSquare extends Square{

	public GoSquare(int position, String name) {
		super(position, name);

	}
	
	public void landOn(Player player)
	{
		player.setMoney(player.getMoney() + 200);
	}

	public void pass(Player player)
	{
		landOn(player);
	}
}
