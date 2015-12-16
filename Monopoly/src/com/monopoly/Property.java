package com.monopoly;

public class Property extends Square {
	boolean isOwned=false, isPremiumProperty=false;
	int houseCount=0;
	
	public Property(String id,String squareType, int price,int rent,String group){
		super(id,squareType,price,rent,group);
	}
	
	public boolean attemptBuyHouse(){
		boolean success = true;
		if(houseCount<5)
			houseCount++;
		else
			success = false;
		return success;
	}
	
	public void setPremiumProperty(boolean isPremiumProperty){
		this.isPremiumProperty = isPremiumProperty;
	}
	
	@Override
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){
		boolean stillInGame=true;
		if(buyIfProperty){
			if(isOwned){
				if(player!=owner){
					int finalPrice=rent;
					if(houseCount!=0){
						finalPrice = rent*10*houseCount;
					}
					else if(isPremiumProperty)
						finalPrice = finalPrice*2;
					if(player.getMoney()>=finalPrice){
						System.out.println("Player " + player.getToken() + " Paying owner " +owner.getToken() + " rent "+finalPrice);
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
				player.buyProperty(this);
				System.out.println(player.getToken()+ " has purchased "+id);
			}
		}
		return stillInGame;
	}
}
