package com.monopoly;

public class IncomeTax extends Square {

	public IncomeTax(String name) {
		super(name);

	}

	@Override
	public void landOn(Player player) {
		
		double amount = Math.min(200, (player.getAccountBalance() * .1));
		player.incrementAccount(-amount);

	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub
		
	}

}
