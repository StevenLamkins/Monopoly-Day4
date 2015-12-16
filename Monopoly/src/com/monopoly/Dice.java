package com.monopoly;

import com.dicegame.Die;

public class Dice {
	
	Die die1 = new Die();
	Die die2 = new Die();

	public int roll() {
		die1.roll();
		die2.roll();
		return die1.getFaceValue() + die2.getFaceValue();
	}

}
