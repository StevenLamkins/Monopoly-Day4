package com.monopoly;

public class Player {
	private Square location;
	private String token;
	private int fund;
	private int moves;
	private int whereAbout=0;
	


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
   public void setFund(int fund)
   {
	   this.fund = fund;
   }

   public int getFund() {
	return fund;
   }

   public int rollDice() {
	   Die d1 = new Die();
	   Die d2 = new Die();
	   moves = d1.roll()+d2.roll(); 
	   whereAbout +=moves;
	   return moves;
   }
   
   public int getWhereAbout()
   {
	   return whereAbout;
   }
}
