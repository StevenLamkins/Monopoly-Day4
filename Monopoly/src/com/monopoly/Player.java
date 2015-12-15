package com.monopoly;


public class Player {

	private Square location;
	private Token token;
    private double money;
	
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
