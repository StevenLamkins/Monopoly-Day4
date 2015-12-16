package com.monopoly;

import com.dicegame.Die;

public class Player {
	private String name;
	private int money;
	private String token;
	private Square location;
	
	public Player(Square startSquare) {
		this.location = startSquare;
		this.money = 1500;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Square getLocation() {
		return location;
	}
	
	public void takeTurn(Die die1, Die die2) {
		int rollValue = die1.roll() + die2.roll();
		System.out.println("roll value is " + rollValue);
		move(rollValue);
	}
	private void move(int rollValue) {
		for (int i=0; i < rollValue; i++){
			System.out.println("current location is " + location);
			location = location.getNextSquare();
			System.out.println("now location is " + location);
		}
	}
	
	
}
