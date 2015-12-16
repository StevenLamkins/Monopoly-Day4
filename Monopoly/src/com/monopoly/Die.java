package com.monopoly;

import java.util.Random;

public class Die {
	
	private int faceValue;
	private int sides;
	public Die()
	{
		this(6);
	}
	public Die(int sides) {
		if (sides <2) throw new IllegalArgumentException("Too few sides");
		this.sides =sides;
		roll();
	}
	public int roll()
	{
		Random rd = new Random();
		this.faceValue= rd.nextInt(6) +1;

		return faceValue;
		
	}
	public void print()
	{
		System.out.println(getFaceValue());
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

}
