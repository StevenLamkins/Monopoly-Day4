package com.monopoly;

public class LoadedDie extends Die{

	public LoadedDie(int randomSeed) {
		super(randomSeed);
	}
	
	public int roll(int roll)
	{
		this.setFaceValue(roll);
		return this.getFaceValue();
	}

}
