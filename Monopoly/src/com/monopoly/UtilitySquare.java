package com.monopoly;

public class UtilitySquare extends PropertySquare {

	private Group group;
	private int rent;

	public UtilitySquare(String name, int rent, int price, Group group) {
		super(name, price);
		this.rent = rent;
		this.group = group;
	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRent() {
		rent = getCurrentRoller().getLastRoll() * 4;
		return rent;
	}

	@Override
	public Group getGroup() {
		// TODO Auto-generated method stub
		return group;
	}

}
