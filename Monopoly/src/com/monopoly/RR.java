package com.monopoly;

public class RR extends Square {

	boolean isOwned=false;	
	
	public RR(String id,String squareType, int price){
		super(id,squareType,price);
	}//end RR constructor
	
	@Override
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){		
		boolean stillInGame=true;
		if(buyIfProperty){
			if(isOwned){
				payRent(player,stillInGame);
			}//end if isOwned			
			else if(player.getMoney()>=this.price){
				buyProperty(player);
			}//end else if
		}//end if buyIfProperty
		return stillInGame;
	}//end handlePlayerLanding
	
	public void payRent(Player player, boolean stillInGame){
		if(player!=owner){
			//rent value to pay
			int finalPrice = owner.getOwnRRCount() * 25;
			//pay rent
			if(player.getMoney()>=finalPrice){
				System.out.println("Player " + player.getToken() + " Paying owner " +owner.getToken() + " rent "+finalPrice);
				player.removeMoney(finalPrice);
				owner.addMoney(finalPrice);
			}//end if
			//No money to pay rent, player loses the games
			else{
				stillInGame=false;
			}//end else
		}//end if player!=owner
	}//end payRent
	
	public void buyProperty(Player player){
		isOwned=true;
		player.removeMoney(this.price);
		owner = player;
		int ownCount=player.getOwnRRCount();
		player.setOwnRRCount(++ownCount);
		System.out.println(player.getToken()+ " has purchased "+id);
	}//end buyProperty

}//end RR class
