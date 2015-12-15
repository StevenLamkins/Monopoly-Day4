package com.monopoly;

import java.util.Random;

public class Die {

	private int max = 6;
	private int min = 1;
	private int faceValue;
	private Random random;
	
	public Die(int randomSeed){
		this(6, randomSeed);
	}
	
	public Die(int sides, int randomSeed) {
		random = new Random(System.currentTimeMillis() * randomSeed);
		if(sides <= 1)
			throw new IllegalArgumentException("Too few sides!");
		this.max = sides;
		this.roll();
	}
	
	int roll()
	{
		faceValue = (int)random.nextInt(max) + min;
		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public int getSides() {
		return max;
	}
}
