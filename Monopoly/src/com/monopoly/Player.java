package com.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	private String token;
	private Square square;
	int money, doubleCount, jailTurnCount, outOfJailFreeCount, previousRoll;
	boolean isInJail=false;
	int ownRRCount=0;
	List<Property> ownedProperties = new ArrayList<Property>();
	Map<String, Integer> ownedGroups = new HashMap<String, Integer>();
	
	public boolean isInJail() {
		return isInJail;
	}

	Player(String token, Square square){
		this.token=token;
		this.square =square;
		this.money=1500;
		this.doubleCount=0;
		this.jailTurnCount=0;
		this.outOfJailFreeCount=0;
	}//end player
	
	public String getToken(){
		return token;
	}//end getToken
	
	public int getOwnRRCount(){
		return ownRRCount;
	}//end getOwnRRCount
	
	public void setOwnRRCount(int ownRRCount){
		this.ownRRCount = ownRRCount;
	}//end setOwnRRCount
	
	public void buyProperty(Property property){
		if(ownedProperties.contains(property))
			System.out.println("Why is this happening");
		else
			ownedProperties.add(property);
		String group = property.getGroup();
		if(ownedGroups.containsKey(group)){
			System.out.println("Group " + group + " moving from " + ownedGroups.get(group));
			ownedGroups.put(group, ownedGroups.get(group)+1);
			System.out.println("Group " + group + " moving from " + ownedGroups.get(group));
		}
		else
			ownedGroups.put(group, 1);
		int ownedAmount = ownedGroups.get(group);
		if(ownedAmount==3 || ((group.equals("purple") || group.equals("darkBlue")) && ownedAmount==2)){
			attemptHouseBuying();
		}
	}
	
	public void attemptHouseBuying(){
		for (Property property : ownedProperties) {
			String group = property.getGroup();
			int ownedAmount = ownedGroups.get(group);
			if(ownedAmount==3 || ((group.equals("purple") || group.equals("darkBlue")) && ownedAmount==2)){
				property.setPremiumProperty(true);
				boolean buyable = true;
				int price=0;
				if(group.equals("purple") || group.equals("lightGreen") || group.equals("violet"))
					price=50;
				else if (group.equals("orange"))
					price = 100;
				else if (group.equals("red") || group.equals("yellow"))
					price = 150;
				else
					price = 200;
				if(money < price){
					buyable = false;
				}
				if(buyable && property.attemptBuyHouse()){
					money-=price;
					System.out.println("********************"+token+" has purchased a house! This is house number "+property.houseCount +"********************");
				}
			}
		}
	}
	
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
	
	public int getPreviousRoll() {
		return previousRoll;
	}

	public void addMoney(int money) {
		this.money+=money;
	}
	
	public void addOutOfJailCard(){
		this.outOfJailFreeCount++;
	}
	
	public boolean removeMoney(int money) {
		boolean success = true;
		if(money>this.money)
			success = false;
		else
			this.money-=money;
		return success;
	}
	
	public boolean takeTurn(Die die, Boolean buyIfProperty){
		boolean stillInGame = true;
		
		attemptHouseBuying();
		
		int roll1 = die.roll();
		int roll2 = die.roll();
		
		boolean wasInJail=false;
		if(isInJail){
			if(outOfJailFreeCount!=0){
				isInJail=false;
				jailTurnCount=0;
				outOfJailFreeCount--;
			}
			else{
				if(roll1==roll2){
					isInJail=false;
					wasInJail=true;
					jailTurnCount=0;
				}
				else if(jailTurnCount<2){
					jailTurnCount++;
					return stillInGame;
				}
				else{
					money-=50;
					isInJail=false;
					jailTurnCount=0;
				}
			}
		}
		
		if (roll1==roll2 && !wasInJail) {
			doubleCount++;
			if (doubleCount==3){
				moveToSquare("jail", false);
				return stillInGame;
			}
		}//end if
		else
			doubleCount=0;
		
		int moveCount = roll1 + roll2;
		for (int i = 0; i < moveCount; i++) {			
			square = square.getNextSquare();
			if (square.getId().equals("GO")) {
				money+=200;
			}
		}
		if(square.getId().equals("go to jail")){
			moveToSquare("jail", false);
			return stillInGame;
		}
		else {
			stillInGame = square.handlePlayerLanding(this, buyIfProperty);
			if(!stillInGame)
				return stillInGame;
		}
			
		if (doubleCount!=0) {
			takeTurn(die, buyIfProperty);
			previousRoll += moveCount;
		}
		else{
			previousRoll = moveCount;
		}
		
		return stillInGame;
	}
	
	public void moveToSquare(String id, boolean buyIfProperty){
		if(id.equals("jail"))
			isInJail=true;
		Boolean squareFound=false;
		int counter=0;
		while(!squareFound && counter<41){			
			counter++;
			square = square.getNextSquare();
			if (square.getId().equals(id)){
				squareFound=true;
			}
		}
		if(squareFound)
			square.handlePlayerLanding(this, buyIfProperty);
	}
	
}//end Player
