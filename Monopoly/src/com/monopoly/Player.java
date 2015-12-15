package com.monopoly;

public class Player {
	
	public static final int FIRST_LOCATION = 0;
	public static final int STARTING_BALANCE = 1500;

	 private int location;
	 private int balance;
	 private String name = "Jacob";
	 private String token = "Dog";
	 
	 public Player() {
		 balance = STARTING_BALANCE;
		 location = FIRST_LOCATION;
	 }
	 
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
