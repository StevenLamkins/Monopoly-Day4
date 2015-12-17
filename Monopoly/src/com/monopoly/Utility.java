package com.monopoly;

public class Utility extends PropSquare {

	public Utility(int price) {
		super("Utility", price);
		
	}

	@Override
	public int getRent() {
		return 50;
	}

	
}
