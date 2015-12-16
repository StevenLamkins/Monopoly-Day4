package com.monopoly;

import java.util.List;

import com.monopoly.squares.Square;

public class Player {
	
	public static final int FIRST_LOCATION = 0;
	public static final int STARTING_BALANCE = 1500;

	 private Square location;
	 private int balance;
	 private String token = "Dog";
	 
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
		int diceSum = d1 + d2;
		int newLoc = diceSum + location.getPosition();
		if (newLoc > 39) {
			balance += 200;
		}
		Square newSquare = board.getSquares().get(newLoc % 40);
		balance -= newSquare.landOnBy(this);
	    setLocation(newSquare);
	}

	public void payRent(int rent) {
		balance -= rent;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	 
	 
	 
	 
}
