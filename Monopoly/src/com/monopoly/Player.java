package com.monopoly;

public class Player
{
  int currentRoll;
  Square currentPosition;
  String piece;
  
  public Player(int playerNumber, Square startSquare){
	  
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
	  Square temp = currentPosition.travel(spaces);
	  currentPosition = temp;
  }
  
  
	

}
