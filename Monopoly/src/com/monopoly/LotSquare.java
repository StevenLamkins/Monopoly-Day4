package com.monopoly;



public class LotSquare extends PropertySquare {

	public LotSquare(String name, int price , int rent) {
		super(name);
		this.price = price;
		this.rent = rent;
	}

	@Override 
	public void landOnBy(Player player) {
		if (!isOwn()) {
			player.purchase(price);
			this.setOwner(player);
		} else {
			player.rent(rent);
			owner.credit(rent);
			
		}
	}

	
}
