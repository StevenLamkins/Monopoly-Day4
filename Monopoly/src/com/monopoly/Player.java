package com.monopoly;

public class Player {
	private int location;
	private int spaceMove;
	private int money;
	private boolean earned200;
	
	public Player() {
		// TODO Auto-generated constructor stub
		location = 0;
		spaceMove = 0;
		this.money = 1500;
		earned200 = false;
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public void setLocation(int location)
	{
		this.location = location;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public void move(int dieRoll){
		
		for(int i = 0; i < dieRoll; i++) {
			
			location += 1;
			passOver(location);
			
			if (location > 39)
			{
				location = 0;	
				
			}
			
			spaceMove += 1;
		}

		arrived(location);
		setEarned200(false);
	}
	
	/*
	 * Land Method -> What should happen when the player lands on the square?
	 * -Pass player to the square and let the square work on it
	 * 		-If the square isn't a special square (yet), do nothing
	 * 		-Else, react by using the appropriate class (goSquare, incomeTaxSquare, LuxuryTaxSquare) to modify the player balance
	 * 
	 */
	
	public void passOver(int location)
	{
		Square currentSquare;
		if(location == 0 && earned200 == false) //Location is Go Square
		{
			currentSquare = new GoSquare(); 
			currentSquare.passOverBy(this);
		}

	}
	
	public void arrived(int location)
	{
		Square currentSquare;
		
		if(location == 0 && earned200 == false) //Location is Go Square
		{
			currentSquare = new GoSquare(); 
			currentSquare.landOn(this);
		}
		else if(location == 4) //Income Tax Square
		{
			currentSquare = new IncomeTaxSquare();
			currentSquare.landOn(this);
		}
		else if(location == 38) //Luxury Tax Square
		{
			currentSquare = new LuxuryTaxSquare();
			currentSquare.landOn(this);
		}
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

	public void setEarned200(boolean earned200) {
		this.earned200 = earned200;
		
	}

}
