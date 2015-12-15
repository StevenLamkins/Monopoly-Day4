package com.monopoly;

import java.util.Random;

public class Die {
	
	int faceValue;
	int maxValue=6;
	int sides;
	
	public Die(){
		this(6);//calls constructor with 'sides' argument		
	}//end Die
	
	public Die(int sides) {
		if (sides < 2) throw new IllegalArgumentException("Too few Sides!");
		this.sides = sides;
		roll();
	}//end Die constructor

	public int getFaceValue() {
		return faceValue;
	}//end get FaceValue
	
	public int roll(){
		//System.out.println("You're roll: " + (int)((Math.random()*10)%6+1));		
		Random rand = new Random();
		faceValue = rand.nextInt(maxValue)+1;
		return faceValue;
	}//end roll	
}//end Die

