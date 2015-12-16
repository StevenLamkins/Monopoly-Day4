package com.monopoly;

public class PropertySquare extends Square {

	private Player owner;
	private int price;
	private int rent;

	public PropertySquare(String name, int rent, int price) {
		super(name);
		this.price = price;
		this.rent = rent;
		owner = null;

	}

	@Override
	public void landOn(Player player) {

		if (owner == null && player.getAccountBalance() >= price) {
			player.debit(price);
			owner = player;
		}
		else if (owner != null)
		{
			player.debit(rent);
			owner.credit(rent);
		}
	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

	public Object getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}

	public int getPrice() {
		return price;

	}

}
