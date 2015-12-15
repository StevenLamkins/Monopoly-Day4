package com.monopoly;

import com.monopoly.MonopolyGame.Token;

public class Player {

	private Square square;
	private Token token;
	
	public Player(Square square, Token token) {
		this.square = square;
		this.token = token;
	}

	public int getPosition(){
		return square.getPosition();
	}

	public Token getToken() {
		return token;
	}

}
