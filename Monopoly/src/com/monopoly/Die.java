package com.monopoly;

import java.util.Random;

public class Die
{
	private int faceValue;
	private int sides;
	

	public Die()
	{
		this(6);
	}
	
	public Die(int sides)
	{
		this.sides = sides;
		if (sides < 2) 
			throw new IllegalArgumentException("Too few sides!");
		roll();
	}

	public int getFaceValue() {
		return faceValue;
	}
	int value = getFaceValue();
	
	public int roll()
	{
		Random rn = new Random();
		faceValue = rn.nextInt(6) + 1;
		return faceValue;
		
		//showResults(dieNum);
	}
	
	public void showResults(int dieNum)
	{
		System.out.println("The face value of die " + dieNum + " is " + faceValue);
		
	}
}
