package com.monopoly;

public class Player {

	private String token;
	private int location;
	
	Player(String token, int location){
		this.token=token;
		this.location=location;
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
	
}//end Player
