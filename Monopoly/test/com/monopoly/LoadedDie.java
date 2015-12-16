package com.monopoly;

public class LoadedDie extends Die {
	private int loadedValue;
	
	public LoadedDie(int loadedValue) {
		this.loadedValue = loadedValue;
	}
	
	public int roll() {
		return loadedValue;
	}
}
