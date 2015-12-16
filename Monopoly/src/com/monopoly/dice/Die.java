package com.monopoly.dice;

import java.util.Random;

public class Die {
	private static Random numGen = new Random();
	private int numSides;
	private int faceValue;
	
	public Die() {
		this(6);
	}
	
	public Die(int numSides) throws IllegalArgumentException {
		if (numSides < 2) throw new IllegalArgumentException("Too few sides!");
		
		this.numSides = numSides;
		
		roll();
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public int getNumSides() {
		return numSides;
	}
	
	public int roll() {
		faceValue = numGen.nextInt(this.numSides) + 1;
		
		return faceValue;
	}
}
