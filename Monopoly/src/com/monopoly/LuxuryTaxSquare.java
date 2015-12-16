package com.monopoly;

public class LuxuryTaxSquare extends Square {

	public LuxuryTaxSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void landOn (Player player) {
		player.setMoney(player.getMoney() - 75);
	}

}
