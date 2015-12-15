package com.monopoly;

public class Player
{
  int currentRoll;
  int currentPosition;
  String piece;
  
  public Player(int token){
	  currentPosition = 0;
	  
	  switch(token)
	  {
	  case 0: this.piece = "DOG";
	  		break;
	  case 1: this.piece = "HAT";
		break;
	  case 2: this.piece = "IRON";
		break;
	  case 3: this.piece = "BOAT";
		break;
	  case 4: this.piece = "CAR";
		break;
	  case 5: this.piece = "WHEELBARROW";
		break;
	  case 6: this.piece = "THUMBLE";
		break;
	  case 7: this.piece = "SHOE";
		break;
	  
	  }
	  
  }
  
  public void setCurrentRoll(int currentRoll)
  {
	this.currentRoll = currentRoll;
  }
  
  public int getCurrentRoll()
  {
	return currentRoll;
  }

public int getCurrentPosition() 
{
	return currentPosition; 
	
}
	

}
