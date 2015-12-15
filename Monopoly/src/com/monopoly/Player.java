package com.monopoly;

import com.dicegame.Die;


public class Player {

	private Square location;
	private Token token;
    private double money;
    
    public void takeTurn(int numOfSq){
        	
    	for (int i=1; i<= numOfSq;i++) {
    		location = location.next();
    	}
    	//System.out.println("Final location:" + location.getName());
    }
	
   	public void setMoney(double money) {
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

	public double getMoney() {
		return money;
	}
}
