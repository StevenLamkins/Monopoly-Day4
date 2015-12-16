package com.monopoly.squares;

import com.monopoly.Player;

public class LotSquare extends Square {
	private String color;
	private int rent;
	private int price;
	private int ownedFlag = 0;

	public LotSquare(int index, String group) {
		super(index);
		color = group;
		rent = rents[position];
		price = prices[position];
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int landOnBy(Player player) {
		return rents[position] * ownedFlag;
	}	

}
