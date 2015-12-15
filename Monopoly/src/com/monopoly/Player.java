package com.monopoly;

import com.monopoly.MonopolyGame.Token;

public class Player {

	private Square square;
	private Token token;
	private int money;
	
	public Player(Square square, Token token) {
		this.money = 1500;
		this.square = square;
		this.token = token;
	}

	public int getPosition(){
		return square.getPosition();
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

}
