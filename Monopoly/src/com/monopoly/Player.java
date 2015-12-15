package com.monopoly;

public class Player {

	private String token;
	private Square square;
	int money, doubleCount;
	Die die = new Die();
	
	Player(String token, Square square){
		this.token=token;
		this.square =square;
		this.money=1500;
		this.doubleCount=0;
	}//end player
	
	public String getToken(){
		return token;
	}//end getToken
	
	public void setToken(String token){
		this.token = token;
	}//end setToken
	
	public Square getSquare(){
		return square;
	}//end getToken
	
	public void setSquare(Square square){
		this.square = square;
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
	
	public boolean takeTurn(){
		boolean stillInGame = true;
		int roll1 = die.roll(12345);
		int roll2 = die.roll(6789);
		if (roll1==roll2) {
			doubleCount++;
			if (doubleCount==3){
				//goto jail
			}
		}//end if
		else
			doubleCount=0;
		int moveCount = roll1 + roll2;
		for (int i = 0; i < moveCount; i++) {			
			square = square.getNextSquare();
			//pass go collect $200
			if (square.getSquareType()=="GO") {
				money+=200;
			}//end if
		}//end for
		if (doubleCount!=0) takeTurn();
		return stillInGame;
	}
	
	public void moveToSquare(String id){
		Boolean squareFound=false;
		int counter=0;
		while(!squareFound && counter<41){			
			counter++;
			square = square.getNextSquare();
			if (square.getId().compareTo(id)==0){
				squareFound=true;
			}//end if
			
			
		}//end for
	}//end moveToSquare
	
}//end Player
