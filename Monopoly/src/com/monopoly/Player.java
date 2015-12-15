package com.monopoly;

import java.util.List;

import com.monopoly.MonopolyGame.Token;

public class Player {

	private List<Die> dice;
	private Square square;
	private Token token;
	private int money;
	
	public Player(Square square, Token token, List<Die> dice) {
		this.money = 1500;
		this.dice = dice;
		this.square = square;
		this.token = token;
	}

	public int getPosition(){
		return square.getPosition();
	}
	
	public Square getSquare(){
		return square;
	}

	public Token getToken() {
		return token;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void takeTurn() {
		move(rollDice());
	}
	
	public int rollDice() {
		int total = dice.get(0).roll() + dice.get(1).roll();
		return total;
	}

	public void move(int value) {
		for(int i = 0; i < value; i++)
		{
			square = square.getNextSquare();
		}
	}
}
