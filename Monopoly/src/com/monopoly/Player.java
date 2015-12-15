package com.monopoly;

public class Player {

	private String token;
	private Square square;
	int money, previousRoll, doubleCount;
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
	
	public int roll(){
		return (die.roll()+die.roll());
	}
	
	public boolean takeTurn(){
		boolean stillInGame = true;
		int moveCount = roll();
		for (int i = 0; i < moveCount; i++) {
			
		}
		return stillInGame;
	}
	
}//end Player
