package com.monopoly;

public class Player {
	private int location;
	private int spaceMove;
	
	public Player() {
		// TODO Auto-generated constructor stub
		location = 0;
		spaceMove = 0;
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public int move(int dieRoll){
		for(int i = 0; i < dieRoll; i++) {
			location += 1;
			if (location > 39)
			{
				location = 0;				
			}
			
			spaceMove += 1;
		}
		return location;
	}

	public boolean verifyMovement(int dieRoll) {
		// TODO Auto-generated method stub
		if (spaceMove == dieRoll)
		{
			return true;
	
		}
		else
		{
			return false;
		}
	}
}
