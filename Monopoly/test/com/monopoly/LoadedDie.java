package com.monopoly;

import com.dicegame.Die;

public class LoadedDie extends Die{
	int loadedValue;
	
	public LoadedDie(int value) {
		loadedValue = value;
	}
	
	public LoadedDie(int maxSides, int value) {

		this.max = maxSides;
		loadedValue = value;		
	}
	
	@Override
	public int roll() {

		return loadedValue;	
	}

}
