package com.monopoly;

public class Player {

	private static final int INITIAL_BALANCE = 1500;
	private Square position;
	private Token token;
	private int balance;

	public Player(Token token, Square initSquare) {
		this.token = token;
		position = initSquare;
		balance = INITIAL_BALANCE;
	}
	
	public Square getPosition() {

		return position;
	}

	public Token getToken() {
		return token;
	}

	public int getBalance() {
		return balance;
	}

	public void takeTurn(Dice dice) {
		int numSpaces = dice.roll();
		Square currSquare = position;
		
		for (int i = 1; i <= numSpaces-1; i++){
			currSquare = currSquare.getNext();
			currSquare.passedBy(this);
		}
		position = currSquare.getNext();
		
		position.landedOnBy(this);
	}

	public void decrementBalance(int amount) {
		balance -= amount;		
	}

	public void incrementBalance(int amount) {
		balance += amount;		
	}

}
