package com.monopoly;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landOn(Player player) {
		// do nothing
		
	}

	@Override
	public void passOver(Player player) {
		player.incrementAccount(200);
		
	}

}
