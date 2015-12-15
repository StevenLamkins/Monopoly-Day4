package com.monopoly;

import com.dicegame.Die;

public class LoadedDie extends Die{
	public LoadedDie(int maxSides, int value) {

		this.max = maxSides;
		this.faceValue = value;		
	}
	
	@Override
	public int roll() {

		return faceValue;	
	}

}
