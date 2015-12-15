package com.monopoly;

public class Player {

	private String token;
	private Square square;
	int money;
	
	Player(String token, Square square){
		this.token=token;
		this.square =square;
		this.money=1500;
	}//end player
	
	public String getToken(){
		return token;
	}//end getToken
	
	public void setToken(String token){
		this.token = token;
	}//end setToken
	
	public Square getSquare(){
		return square;
	}//end getToken
	
	public void setSquare(Square square){
		this.square = square;
	}//end setToken

	public int getMoney() {
		return money;
	}

	public void addMoney(int money) {
		this.money+=money;
	}
	
	public boolean removeMoney(int money) {
		boolean success = true;
		if(money>this.money)
			success = false;
		else
			this.money-=money;
		return success;
	}
	
}//end Player
