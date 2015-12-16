package com.monopoly;

public class LuxurySquare extends Square {
	public LuxurySquare(int position)
	{
		super(position,"LUXURY TAX");
	}
	
	@Override
	public void action(Player player)
	{
		player.addMoney(-75);
	}
	
}
