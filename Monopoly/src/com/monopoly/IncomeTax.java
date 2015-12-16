package com.monopoly;

public class IncomeTax extends Square {

	public IncomeTax(String name) {
		super(name);

	}

	@Override
	public void landOn(Player player) {

		if (player.getAccountBalance() >= 2000) {
			player.incrementAccount(-200);
		} else {

			player.incrementAccount(player.getAccountBalance() * .1);
		}

	}

}
