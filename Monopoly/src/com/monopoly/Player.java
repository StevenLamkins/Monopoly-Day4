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
    private int rolledValue;
    
    public void takeTurn(Die die){
        	
    	rolledValue = die.roll();
    	rolledValue += die.roll();
    	
    	move(rolledValue);
    	
    }

	private void move(int numOfSq) {
		for (int i=0; i< numOfSq - 1 ;i++) {
			location = location.next();
			location.passBy(this);
		}
		location = location.next();
		location.landOnBy(this);
		if (location instanceof PropSquare) {
			buyProperty((PropSquare)location);
		}
      	
	}     
	
	public void buyProperty(PropSquare property){
		
		int propertyValue = property.getPrice();
		if((money >= propertyValue) && !property.isOwned()){
			debit(propertyValue);
			property.setOwner(this);
		}
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

	public void credit(int amount) {
		this.money += amount;
		
	}
	
	public void debit(int amount){
		this.money -= amount;
	}

	public int getLastRoll() {
		
		return rolledValue;
	}
}
