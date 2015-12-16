package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.squares.Square;

public class Player {
	
	public static final int FIRST_LOCATION = 0;
	public static final int STARTING_BALANCE = 1500;

	 private Square location;
	 private int balance;
	 private String token = "Dog";
	 private List<Square> deeds = new ArrayList<>();
	 private int lastRoll = 0;
	 
	 public Player() {
		 balance = STARTING_BALANCE;
	 }
	 
	public Square getLocation() {
		return location;
	}
	
	public void setLocation(Square location) {
		this.location = location;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getBalance() {
		return balance;
	}

	public void takeTurn(List<Die> dice, Board board) {
		int d1 = dice.get(0).roll();
		int d2 = dice.get(1).roll();
		lastRoll = d1 + d2;
		int newLoc = lastRoll + location.getPosition();
		if (newLoc > 39) {
			credit(200);
		}
		Square newSquare = board.getSquares().get(newLoc % 40);
		debit(newSquare.landOnBy(this));
	    setLocation(newSquare);
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Square> getDeeds() {
		return deeds;
	}

	public void credit(int amount) {
		balance += amount;
	}

	public void debit(int amount) {
		balance -= amount;
	}

	public int getLastRoll() {
		return lastRoll;
	}
	 
	 
	 
	 
}
