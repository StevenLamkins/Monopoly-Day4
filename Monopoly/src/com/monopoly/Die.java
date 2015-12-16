package com.monopoly;

import java.util.Random;

public class Die {
	private int faceValue;
	Random randomGenerator = new Random();
	private int sides;
	
	public Die() {
		this(6);
	}
	
	public Die(int sides) {
		if (sides < 2) throw new IllegalArgumentException("Too few sides!");
		this.sides = sides;
		roll();
	}

	public int roll() {
		faceValue = randomGenerator.nextInt(this.sides) + 1;
		return faceValue;		
	}
	
	public int getFaceValue() {
		return faceValue;
	}
}
