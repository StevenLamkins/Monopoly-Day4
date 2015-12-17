package com.monopoly;

import java.util.List;

import com.monopoly.squares.Square;

public interface PlayerInfo {

	public abstract Square getLocation();

	public abstract String getToken();

	public abstract int getBalance();

	public abstract List<Square> getDeeds();

	public abstract int getLastRoll();

}