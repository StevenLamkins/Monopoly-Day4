package com.monopoly;

public class LotSquare extends PropertySquare {

	private int rent;

	public LotSquare(String name, int squareNumber) {
		super(name, squareNumber);
		rent = squareNumber;
	}

	@Override
	public int calculateRent(Player player) {
		return rent;
	}
	
}
