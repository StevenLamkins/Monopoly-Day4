package com.monopoly;

public enum Token {

	TERRIER("TERRIER"), 
	BATTLESHIP("BATTLESHIP"), 
	CAR("CAR"), 
	HAT("HAT"), 
	THIMBLE("THIMBLE"), 
	BOOT("BOOT"), 
	WHEEL("WHEEL"), 
	CAT("CAT");
	
	private final String text;
	
	private Token(final String text){
		this.text=text;
	}
	
	@Override
	public String toString(){
		return text;		
	}
	
}
