package com.monopoly;

public interface PlayerInfo {

	public abstract Square getLocation();

	public abstract Token getToken();

	public abstract int getMoney();

	public abstract int getLastRoll();

}