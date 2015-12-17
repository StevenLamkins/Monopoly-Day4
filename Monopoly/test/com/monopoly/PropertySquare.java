package com.monopoly;

public abstract class PropertySquare extends Square {
	
	protected Player owner;

	public PropertySquare(String name, int squareNumber) {
		super(name, squareNumber);
	}
	
	public PlayerInfo getOwner() {
		return owner;
	}

	public int getPrice() {
		return squareNumber * 10;
	}
	
	@Override
	public void landedOnBy(Player player) {
		transferOwnership(player);
		chargeRent(player);
	}

	private void chargeRent(Player player) {
		if (owner != null) {
			if (player.equals(owner)) return;
			owner.incrementBalance(calculateRent(player));
			player.decrementBalance(calculateRent(player));
		}
	}

	private void transferOwnership(Player player) {
		if (owner != null) return;
		if (player.equals(owner)) return;
		if (player.getBalance() >= getPrice()) {
			owner = player;
			player.decrementBalance(getPrice());
		}
	}
	
	public abstract int calculateRent(Player player);
	
}
