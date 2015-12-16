package com.monopoly.squares;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.Player;

public class RailroadProperty extends Property {

	public RailroadProperty(int position, String name, String group, int value, int rent) {
		super(position, name, group, value, rent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void purchase(Player owner) {
		super.purchase(owner);
		List<Property> list = new ArrayList<>();
		for(Property property: owner.getProperties())
		{
			if("Railroad".equals(property.getGroup()))
			{
				list.add(property);
			}
		}
		
		if(list.size() > 1)
		{
			for(Property property: list){
				property.setRent(property.getRent() * 2);
			}
		}
	}
}
