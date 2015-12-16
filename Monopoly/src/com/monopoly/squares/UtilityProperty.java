package com.monopoly.squares;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.Player;

public class UtilityProperty extends Property{

	public UtilityProperty(int position, String name, String group, int value,
			int rent) {
		super(position, name, group, value, rent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void purchase(Player owner) {
		super.purchase(owner);
		List<Property> list = new ArrayList<>();
		for(Property property: owner.getProperties())
		{
			if("Utilities".equals(property.getGroup()))
			{
				list.add(property);
			}
		}
		
		if(list.size() > 1)
		{
			for(Property property: list){
				property.setRent(10);
			}
		}
	}

	@Override
	protected int calculateRent(Player player) {
		return getRent() * player.getLastRoll();
	}
}
