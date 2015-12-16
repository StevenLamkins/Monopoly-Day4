package com.monopoly;

import com.dicegame.Die;


public class Player {

	public Player(Square location, Token token) {
		this.location = location;
		this.token = token;
		this.money = 1500;
	}

	private Square location;
	private Token token;
    private int money;
    
    public void takeTurn(Die die){
        	
    	int numOfSq = die.roll();
    	numOfSq += die.roll();
    	
    	move(numOfSq);
    	balanceMoney();
    }

	private void balanceMoney() {
		System.out.println("Location name: " + location.getName());
		money += location.getPrice();
	}

	private void move(int numOfSq) {
		for (int i=1; i<= numOfSq;i++) {
    		location = location.next();
    	}
	}     
	
   	public void setMoney(int money) {
		this.money = money;
	}
    
	public void setToken(Token token) {
		this.token = token;
	}

	public String getToken() {
		return token.toString();
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	public int getMoney() {
		return money;
	}
}
