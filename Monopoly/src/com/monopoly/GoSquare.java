package com.monopoly;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		player.incrementAccount(200);
		
	}

}
