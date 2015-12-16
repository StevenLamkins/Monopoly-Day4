package com.monopoly.dice;

public class LoadedDie extends Die {
	private int loadedValue;
	
	public LoadedDie(int loadedValue) {
		this.loadedValue = loadedValue;
	}
	
	@Override
	public int roll() {
		return loadedValue;
	}
}
