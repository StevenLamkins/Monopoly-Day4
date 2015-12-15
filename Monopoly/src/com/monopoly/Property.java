package com.monopoly;

public class Property extends Square {
	boolean isOwned=false;
	int houseCount=0;
	
	public Property(String id,String squareType, int price,int rent,String group){
		super(id,squareType,price,rent,group);
	}
	
	@Override
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){
		boolean stillInGame=true;
		if(buyIfProperty){
			if(isOwned){
				if(player!=owner){
					int finalPrice=rent;
					if(houseCount!=0){
						finalPrice = rent*5*houseCount;
					}
					if(player.getMoney()>=finalPrice){
						player.removeMoney(finalPrice);
						owner.addMoney(finalPrice);
					}
					else{
						stillInGame=false;
					}
				}
			}
			else if(player.getMoney()>=this.price){
				isOwned=true;
				player.removeMoney(this.price);
				owner = player;
			}
		}
		return stillInGame;
	}
}
