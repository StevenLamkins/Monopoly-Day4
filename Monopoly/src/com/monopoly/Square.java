package com.monopoly;

public class Square {

	String id;
	String squareType;
	int price;
	int rent;
	String group;
	Square nextSquare;
	Player owner;
	
	public Square getNextSquare() {
		return nextSquare;
	}
	
	public String getGroup(){
		return group;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public Square(String id,String squareType, int price,int rent,String group){
		this.id=id;
		this.squareType =squareType;
		this.price = price;
		this.rent = rent;
		this.group = group;
	}//end Square Constructor
	
	public Square(String id,String squareType){
		this.id=id;
		this.squareType =squareType;		
	}//end Square Constructor
	
	public Square(String id,String squareType, int price){
		this.id=id;
		this.squareType =squareType;
		this.price = price;		
	}//end Square Constructor
	
	public String getId(){
		return id;
	}

	public String getSquareType() {
		return squareType;		
	}
	
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){
		boolean stillPlaying=true;
		if(id.equals("income tax")){
			if(player.money>2000)
				player.removeMoney(200);
			else
				player.removeMoney((int) (player.money*.1));
			System.out.println(player.getToken()+ " Paying income tax! new money: "+player.money);
		}
		else if(id.equals("luxury tax")){
			if(player.money>=75)
				player.removeMoney(75);
			else
				stillPlaying = false;
			System.out.println(player.getToken()+ " Paying luxury tax! new money: "+player.money);
		}
		return stillPlaying;
	}

	public Player getOwner() {
		return owner;
	}
	
}//end Square
