package com.monopoly;

import java.util.Random;

public class Die {
	
	int faceValue;
	int maxValue=6;
	int sides;
	int loadedDiceValue = 0;
	boolean noDoubles=false;
	
	public Die(){
		this(6);//calls constructor with 'sides' argument		
	}//end Die
	
	public Die(int sides) {
		if (sides < 2) throw new IllegalArgumentException("Too few Sides!");
		this.sides = sides;		
	}//end Die constructor
	
	public Die(int sides, int loadedDiceValue) {
		if (sides < 2) throw new IllegalArgumentException("Too few Sides!");
			this.sides = sides;
		this.loadedDiceValue=loadedDiceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}//end get FaceValue
	
	public int roll(int seed){
		int returnValue;
		if (loadedDiceValue!=0){
			if(!noDoubles)
				returnValue=loadedDiceValue;
			else
				returnValue=loadedDiceValue+1;
			noDoubles=!noDoubles;
		} 
		else{
			Random rand = new Random(seed);
			faceValue = rand.nextInt(maxValue)+1;
			returnValue = faceValue;
		}
		return returnValue;
	}//end roll	
}//end Die

