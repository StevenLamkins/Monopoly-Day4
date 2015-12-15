package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int token;
	private int balance;
	private int position;
	private List<Square> properties;
	private int doubleCount;
	
	public Player(int token, int balance) {
		this.token = token;
		this.balance = balance;
		this.position = 0;
		this.properties = new ArrayList<>();
	}
	
	public int getToken() {
		return token;
	}
	
	public int getBalance() {
		return balance;
	}
		
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public List<Square> getProperties() {
		return properties;
	}
	
	public int withdraw(int amount) {
		if (amount > balance) throw new IllegalArgumentException("Insufficient funds!");
		
		balance -= amount;
		
		return balance;
	}
	
	public int deposit(int amount) {
		balance += amount;
		
		return balance;
	}
	
	public int getDoubleCount() {
		return doubleCount;
	}
	
	public void incrementDoubleCount() {
		doubleCount++;
	}
	
	public void resetDoubleCount() {
		doubleCount = 0;
	}
}
