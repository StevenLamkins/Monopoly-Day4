package com.monopoly;

import java.util.List;

import com.dicegame.Die;

public class Player {
	private Square square;
	private String tokenStr;
	private Token token;
	private double accountBalance;

	public static final String[] TOKENS = { "Dog", "WheelBarrow", "Hat",
			"Thimble", "Battleship", "Race Car", "Boot", "Iron" };

//	public Player(Square square, int tokenIndex) {
//		this.square = square;
//		token = TOKENS[tokenIndex];
//		accountBalance = 1500.0;
//	}
	
	public Player(Square square, Token token) {
		this.square = square;
		this.token = token;
		accountBalance = 1500.0;
	}

	public Square getSquare() {
		return square;
	}

	public Token getToken() {
		return token;
	}

	public void takeTurn(List<Die> dice) {
		int dieCount1 = dice.get(0).roll();
		int dieCount2 = dice.get(1).roll();

		int moveCount = dieCount1 + dieCount2;

		movePlayer(moveCount);
	}

	private void movePlayer(int moveCount) {
		for (int i = 0; i < moveCount -1; i++) {
			step();
				getSquare().passOver(this);
		}
		step();
		getSquare().landOn(this);

	}

	private void step() {
		setSquare(getSquare().getNextSquare());
	}

	private void setSquare(Square square) {
		this.square = square;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void incrementAccount(double amount) {
		accountBalance += amount;
	}
	
	public void credit(double amount) {
		accountBalance += amount;
	}
	
	public void debit(double amount) {
		System.out.println("Hit this point3");
		accountBalance -= amount;
	}
	

}
