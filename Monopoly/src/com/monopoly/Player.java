package com.monopoly;

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

	public Object getBalance() {
		return balance;
	}
	 
	 
	 
	 
}
