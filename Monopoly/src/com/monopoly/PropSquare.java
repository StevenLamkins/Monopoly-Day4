package com.monopoly;

public abstract class PropSquare extends Square {

	private Player owner;
	private int price;

	public PropSquare(String name, int price) {
		super(name);
		this.price = price;
	}
	
	@Override
	public void landOnBy(Player aPlayer) {
		if((aPlayer.getMoney() >= price) && !isOwned()){
			aPlayer.debit(price);
			owner = aPlayer;
		}
	}

	public boolean isOwned() {

		if (owner == null) {
			return false;
		} else
			return true;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
