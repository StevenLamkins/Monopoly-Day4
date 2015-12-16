package com.monopoly;

public class GoSquare extends Square {

	public GoSquare() {
		super("Go Square");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOnBy(Player aPlayer) {

		aPlayer.credit(200);
	}

	@Override
	public void passBy(Player aPlayer) {

		aPlayer.credit(200);
	}

}
