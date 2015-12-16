package com.monopoly;

public class LotSquare extends PropertySquare {

	private Group group;

	public LotSquare(String name, int rent, int price, Group group) {
		super(name, rent, price);

		this.group = group;
	}


	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

}
