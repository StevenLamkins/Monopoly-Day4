package com.monopoly;

import com.dicegame.Die;

public class LoadedDie extends Die {

	
	private int loadedValue;
	
	public LoadedDie(int value) {
		loadedValue = value;
	}
	@Override
	public int roll() {
		return loadedValue;
	}
}
