package com.monopoly.player;

import java.util.List;

import com.monopoly.squares.Square;

public interface PlayerInfo {

	public abstract Piece getPiece();

	public abstract int getBalance();

	public abstract int getPosition();

	public abstract List<Square> getProperties();

}