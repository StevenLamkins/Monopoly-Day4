package com.monopoly;

public class Player {

	private String token;
	private int location, money;
	
	Player(String token, int location){
		this.token=token;
		this.location=location;
		this.money=1500;
	}//end player
	
	public String getToken(){
		return token;
	}//end getToken
	
	public void setToken(String token){
		this.token = token;
	}//end setToken
	
	public int getLocation(){
		return location;
	}//end getToken
	
	public void setLocation(int location){
		this.location = location;
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
