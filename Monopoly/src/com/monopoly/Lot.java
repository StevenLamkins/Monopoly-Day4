package com.monopoly;

public class Lot extends PropSquare {

	private int rent;
	
	public Lot(String name, int price, int rent) {
		super(name, price);
		this.rent=rent;
	}

	@Override
	public int getRent() {
		return rent;
	}
}
