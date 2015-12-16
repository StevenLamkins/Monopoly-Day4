package com.monopoly;

public class Utility extends Square {

	boolean isOwned=false;	
	int ownCount=0;
	
	public Utility(String id,String squareType, int price){
		super(id,squareType,price);
	}//end Utility constructor
	
	@Override
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){		
		boolean stillInGame=true;
		if(buyIfProperty){
			if(isOwned){
				if(player!=owner){
					//pay rent
					Die die = new Die();
					//rent value to pay
					int finalPrice=0;
					if(ownCount<2){
						finalPrice = 4 * (die.roll());
					}//end ownCount<2
					else if (ownCount==2){
						finalPrice = 10 * (die.roll());
					}//end ownCount==2
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
			else if(player.getMoney()>=this.price){
				isOwned=true;
				ownCount++;
				player.removeMoney(this.price);
				owner = player;				
			}//end else if player.getMoney()>=this.price
		}//end if buyIfProperty
		return stillInGame;
	}//end handlePlayerLanding
	
}//end Utility
