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
				if(player!=owner){
					//rent value to pay
					int finalPrice = owner.getOwnRRCount() * 25;
					//pay rent
					if(player.getMoney()>=finalPrice){
						player.removeMoney(finalPrice);
						owner.addMoney(finalPrice);
					}//end if
					//No money to pay rent, player loses the games
					else{
						stillInGame=false;
					}//end else
				}//end if player!=owner
			}//end if isOwned			
			//buy property
			//increase ownCount
			else if(player.getMoney()>=this.price){
				isOwned=true;
				player.removeMoney(this.price);
				owner = player;
				int ownCount=player.getOwnRRCount();
				player.setOwnRRCount(++ownCount);				
			}//end else if
		}//end if buyIfProperty
		return stillInGame;
	}//end handlePlayerLanding
	
}//end RR class
