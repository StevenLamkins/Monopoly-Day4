package com.monopoly;

public interface PlayerInfo {

	public abstract Square getPosition();

	public abstract Token getToken();

	public abstract int getBalance();

	public abstract int getlastRoll();

}