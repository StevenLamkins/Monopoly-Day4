package com.monopoly;

public abstract class Property extends Square
{
	private Player owner;
	private int price;
	private int rent;

	public Property(int position, String name)
	{
		super(position, name);
		// TODO Auto-generated constructor stub
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	
	public Player getOwner()
	{
		return owner;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	public int getPrice() 
	{
		return price;
	}
	
	public void setRent(int rent) 
	{
		this.rent = rent;
	}
	
	public int getRent()
	{
		return rent;
	}
	
	
	public void action(Player player)
	{
		if(getOwner() == null && (player.getMoney() > price) )
		{
			player.buy(this);
		}
		else if(getOwner() != null)
		{
			player.payRent(this);
		}
		else
		{
			//Do Nothing
		}
	}

}
