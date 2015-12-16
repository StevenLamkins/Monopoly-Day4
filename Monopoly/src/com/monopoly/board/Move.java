package com.monopoly.board;

import com.monopoly.player.Player;
import com.monopoly.squares.Square;

public class Move {
	private Player player;
	private Square square;
	private boolean takeChances;
	private int oldPosition;
	private int newPosition;
	private int roll;
	
	public Move(Player p, Square s, boolean takeChances, int oldPos, int newPos, int roll) {
		this.player = p;
		this.square = s;
		this.takeChances = takeChances;
		this.oldPosition = oldPos;
		this.newPosition = newPos;
		this.roll = roll;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Square getSquare() {
		return square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public boolean getTakeChances() {
		return takeChances;
	}
	
	public void setTakeChances(boolean takeChances) {
		this.takeChances = takeChances;
	}
	
	public int getOldPosition() {
		return oldPosition;
	}
	
	public void setOldPosition(int oldPosition) {
		this.oldPosition = oldPosition;
	}
	
	public int getNewPosition() {
		return newPosition;
	}
	
	public void setNewPosition(int newPosition) {
		this.newPosition = newPosition;
	}
	
	public int getRoll() {
		return roll;
	}
	
	public void setRoll(int roll) {
		this.roll = roll;
	}	
}
