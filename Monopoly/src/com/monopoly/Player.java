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
		
		for (int i = 0; i < numSpaces; i++){
			currSquare = currSquare.getNext();
		}
		position = currSquare;
	}

}
