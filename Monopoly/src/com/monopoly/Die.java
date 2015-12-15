package com.monopoly;

import java.util.Random;

public class Die {
	
	private static int faceValue;
	
	public Die(){
		rollDice();
	}
	
	public static int getFaceValue() {
		return faceValue;
	}

	public static int rollDice() {
		Random randomGenerator = new Random();
		faceValue = randomGenerator.nextInt(6) + 1;
		return faceValue;

	}

}
