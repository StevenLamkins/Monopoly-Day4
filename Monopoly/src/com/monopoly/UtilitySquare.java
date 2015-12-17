package com.monopoly;

public class UtilitySquare extends PropertySquare {

	public UtilitySquare(String name, int squareNumber) {
		super(name, squareNumber);
	}

	@Override
	public int calculateRent(Player player) {
		int lastRoll = player.getLastRoll();
		return 4*lastRoll;
	}

}
