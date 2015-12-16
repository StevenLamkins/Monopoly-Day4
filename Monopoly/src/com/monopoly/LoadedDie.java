package com.monopoly;

public class LoadedDie extends Die{

	public LoadedDie(int faceValue) {
		super(5353);
		this.setFaceValue(faceValue);
	}
	
	@Override
	public int roll()
	{
		return this.getFaceValue();
	}

}
