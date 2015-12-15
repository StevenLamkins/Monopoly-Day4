package com.monopoly;

public class WrongNumberOfPlayers extends IllegalArgumentException {

	public WrongNumberOfPlayers (String message){
		super(message);
	}
}
