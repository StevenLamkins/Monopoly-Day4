package com.monopoly;

import com.monopoly.MonopolyGame.Token;
import com.monopoly.squares.Square;

public interface PlayerData {

	public abstract Square getSquare();

	public abstract Token getToken();

	public abstract int getMoney();

	public abstract int getLastRoll();

}