package com.monopoly;

public class IncomeTaxSquare extends Square {

	public IncomeTaxSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn (Player player) {
		
		if (player.getMoney() < 2000 ) {
		Double newMoney = player.getMoney() -    (player.getMoney() * .1);
		player.setMoney(newMoney.intValue());
		}
		else {
			if (player.getMoney() >= 2000) {
			 player.setMoney(player.getMoney() -  200);
			}
		}
	}
}
