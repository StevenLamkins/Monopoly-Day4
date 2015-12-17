package com.monopoly;

public class Player
{
  int currentRoll;
  Square currentPosition;
  String piece;
  int money;
  
  public Player(int playerNumber, Square startSquare)
  {
	  
	  
	  switch(playerNumber)
	  {
	  case 0: this.piece = "Dog";
	  		break;
	  case 1: this.piece = "Iron";
		break;
	  case 2: this.piece = "Shoe";
		break;
	  case 3: this.piece = "Racecar";
		break;
	  case 4: this.piece = "Battleship";
		break;
	  case 5: this.piece = "Thimble";
		break;
	  case 6: this.piece = "Wheelbarrow";
		break;
	  case 7: this.piece = "TopHat";
		break;
	  
	  }
	  
	  
	  money = 1500;
	  currentPosition = startSquare;
	  
  }
  
  public void setCurrentRoll(int currentRoll)
  {
	this.currentRoll = currentRoll;
  }
  
  public int getCurrentRoll()
  {
	return currentRoll;
  }

  public Square getCurrentPosition() 
  { 
	return currentPosition; 
	
  }

  public String getName()
  {
	return piece;
  }

  public void move(int spaces) 
  {
	  Square initialPosition =  currentPosition;
	  Square temp = currentPosition.travel(spaces);
	  currentPosition = temp;
	  
	  currentPosition.action(this);
	  Square landingPosition = currentPosition;
	  
	  passGo(initialPosition, landingPosition);
	  
  }

private void passGo(Square initialPosition, Square landingPosition) {
	if(landingPosition.getPosition() - initialPosition.getPosition() < 0)
	  {
		  addMoney(200);
	  }
}
  
  public int getMoney()
  {
	  return money;
  }
  
  public void takeTurn(Die die1, Die die2) {
		int rollValue = die1.roll() + die2.roll();
		move(rollValue);
		currentRoll = rollValue;
	}

public void addMoney(int i) {
	money = money + i;	
}

public void buy(Property property)
{
	money = money - property.getPrice();
	property.setOwner(this);
}

public void payRent(Property property)
{
	money = money - property.getRent();
	property.getOwner().addMoney(property.getRent());
}

  
  


}
