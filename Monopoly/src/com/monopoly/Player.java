package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private Piece piece;
	private int balance;
	private int position;
	private List<Square> properties;
	private int doubleCount;
	private boolean inJail;
	private int jailRollCount;
	
	public Player(Piece piece, int balance) {
		this.piece = piece;
		this.balance = balance;
		this.position = 0;
		this.properties = new ArrayList<>();
	}
	
	public Piece getPiece() {
		return piece;
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
	
	public void addProperty(Square s) {
		properties.add(s);
	}
	
	public int withdraw(int amount) {
		if (amount > balance) {
			balance = 0;
		} else {
			balance -= amount;
		}
		
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
	
	public boolean inJail() {
		return this.inJail;
	}
	
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	public int getJailRollCount() {
		return jailRollCount;
	}
	
	public void incrementJailRollCount() {
		jailRollCount++;
	}
	
	public void resetJailRollCount() {
		jailRollCount = 0;
	}
	
	@Override
	public String toString() {
		return "Player " + piece.name();
	}
}
