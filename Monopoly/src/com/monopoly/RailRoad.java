package com.monopoly;

public class RailRoad extends PropSquare {

	public RailRoad(int price) {
		super("Rail Road", price);
		
	}

	@Override
	public int getRent() {
		return 50;
	}

	
}
