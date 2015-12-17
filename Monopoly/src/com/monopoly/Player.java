package com.monopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Player implements PlayerInfo {

	private static final int INITIAL_BALANCE = 1500;
	private Square position;
	private Token token;
	private int balance;
	private int lastRoll;

	public Player(Token token, Square initSquare) {
		this.token = token;
		position = initSquare;
		balance = INITIAL_BALANCE;
	}
	
	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getPosition()
	 */
	@Override
	public Square getPosition() {

		return position;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getToken()
	 */
	@Override
	public Token getToken() {
		return token;
	}

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getBalance()
	 */
	@Override
	public int getBalance() {
		return balance;
	}

	public void takeTurn(Dice dice) {
		lastRoll = dice.roll();
		Square currSquare = position;
		
		for (int i = 1; i <= lastRoll-1; i++){
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

	/* (non-Javadoc)
	 * @see com.monopoly.PlayerInfo#getlastRoll()
	 */
	@Override
	public int getLastRoll() {
		return lastRoll;
	}

}
