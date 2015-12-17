package com.monopoly;

public abstract class PropertySquare extends Square {

	private int price;
	private Player owner;

	public PropertySquare(String name, int price) {
		super(name);
		this.price = price;
	}
	 
	@Override
	public void landOnBy(Player player) {
		if(isForSale())
		{	
			purchaseProperty(player);
		}
		else{
			collectRent(player);
		}
	}

	private void collectRent(Player player) {
		player.debit(calculateRent());
		owner.credit(calculateRent());
	}

	private void purchaseProperty(Player player) {
		if(player.getMoney() >= price){
			player.debit(price);
			this.owner = player;
		}
	}

	private boolean isForSale() {
		return this.getOwner() == null;
	}

	public Player getOwner() {
		return owner;
	}
	
	public abstract int calculateRent();

}
