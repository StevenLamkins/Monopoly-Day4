package com.monopoly;

public class LoadedDice extends Dice {
	
	private int rollValue;

	public LoadedDice(int rollValue) {
		this.rollValue = rollValue;
	}
	
	public int roll() {
		return rollValue;
	}

}
