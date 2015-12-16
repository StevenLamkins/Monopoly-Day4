package com.monopoly.squares;

import com.monopoly.Player;

public abstract class PropertySquare extends Square {

	protected Player owner;
	protected int price;
	protected int rent;
	
	public PropertySquare(int position) {
		super(position);
		price = prices[position];
		rent = rents[position];
	}

	public Player getOwner() {
		return owner;
	}

	public int getPrice() {
		return 0;
	}

	@Override
	public int landOnBy(Player player) {
		if ((owner == null) && (player.getBalance() > price)) {
			owner = player;
			player.getDeeds().add(this);
			return price;
		}
		else if ((owner != null) && (owner != player)) {
			int rent = collectRent(player);
			return rent;
		}
		else {
			return 0;
		}
	}

	abstract public int collectRent(Player player);
	
}
