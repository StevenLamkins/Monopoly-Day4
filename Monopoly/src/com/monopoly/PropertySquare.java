package com.monopoly;

public class PropertySquare extends Square {

	private Player owner;
	private int price;

	public PropertySquare(String name, int price) {
		super(name);
		this.price = price;
		owner = null;

	}

	@Override
	public void landOn(Player player) {

		if (owner == null && player.getAccountBalance() >= price) {
			player.debit(price);
			owner = player;
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
