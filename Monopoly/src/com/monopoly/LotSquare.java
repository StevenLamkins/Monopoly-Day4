package com.monopoly;

public class LotSquare extends PropertySquare {
	
	private int rent;
	private Group group;

	public LotSquare(String name, int rent, int price, Group group) {
		super(name, price);
		this.rent = rent;
		this.group = group;
	}


	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

}
