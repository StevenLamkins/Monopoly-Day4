package com.monopoly.squares;

import com.monopoly.board.Move;

public abstract class SquareType {
	protected SquareGroup group;
	protected int price;
	protected int rent;
	protected int houseBuildingCost;
	protected int numHouses;
	
	protected SquareType(SquareGroup group, int price, int rent) {
		this.group = group;
		this.price = price;
		this.rent = rent;
		
		switch (group) {
			case PURPLE:
			case LIGHT_GREEN:
				houseBuildingCost = 50;
				break;
			case VIOLET:
			case ORANGE:
				houseBuildingCost = 100;
				break;
			case RED:
			case YELLOW:
				houseBuildingCost = 150;
				break;
			case DARK_GREEN:
			case DARK_BLUE:
				houseBuildingCost = 200;
				break;
			default:
				break;
		}
	}
	
	public final SquareGroup getGroup() {
		return group;
	}
	
	public final int getPrice() {
		return price;
	}
	
	public final int getRent() {
		return (int) (rent + (rent * 1.25) * numHouses);
	}
	
	public final int getNumHouses() {
		return numHouses;
	}
	
	public final int getHouseBuildingCost() {
		return houseBuildingCost;
	}
	
	public final int addHouse() {
		return ++numHouses;
	}
	
	public final int removeHouse() {
		if (numHouses > 0) numHouses--;
		
		return numHouses;
	}
	
	public abstract void handleMove(Move move);
}
