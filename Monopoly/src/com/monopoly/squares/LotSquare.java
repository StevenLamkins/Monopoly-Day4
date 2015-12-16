package com.monopoly.squares;

import com.monopoly.Player;

public class LotSquare extends PropertySquare {
	private String color;

	public LotSquare(int index, String group) {
		super(index);
		color = group;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int collectRent(Player player) {
		owner.credit(rents[position]);
		return rents[position];
	}
	
	


}
