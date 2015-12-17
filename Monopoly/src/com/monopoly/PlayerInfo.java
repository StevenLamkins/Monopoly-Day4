package com.monopoly;

public interface PlayerInfo {

	public abstract Square getSquare();

	public abstract Token getToken();

	public abstract double getAccountBalance();
	
	public abstract int getLastRoll();	

}