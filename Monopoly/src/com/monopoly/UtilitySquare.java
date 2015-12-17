package com.monopoly;

public class UtilitySquare extends PropertySquare{
	public UtilitySquare(String name, int price) {
		super(name, price);
	}
	
	public int calculateRent(){
		return 1 * 4;
	}
}