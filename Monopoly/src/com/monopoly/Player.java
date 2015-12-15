package com.monopoly;

public class Player {
	private Square location;
	private String token;


	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	public String getToken() {

		return token;
	}
	
   public void setToken(String token)
   {
	   this.token = token;
   }
   
   public boolean isOnGo () {
	   return location.getName().equals("Go");
   }
}
