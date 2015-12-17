package com.monopoly;

public class LotSquare extends PropertySquare {

	private Group group;
	private int rent;

	public LotSquare(String name, int rent, int price, Group group) {
		super(name, price);
		this.rent = rent;
		this.group = group;
	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public int chargeRent() {
		// TODO Auto-generated method stub
		return rent;
	}

	@Override
	public Group getGroup() {
		// TODO Auto-generated method stub
		return group;
	}

}
