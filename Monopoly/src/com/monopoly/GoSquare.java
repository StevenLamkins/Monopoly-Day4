package com.monopoly;

public class GoSquare extends Square {

	public GoSquare(int position) {
		super(position,"GO");
	}
	
	public void action(Player player)
	{
		player.addMoney(200);
	}

}
