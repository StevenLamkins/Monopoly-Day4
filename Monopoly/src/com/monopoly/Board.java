package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	List<Space> spaces;
	
	public Board () {
		spaces = new ArrayList<Space>(40);
		
		for(int i =0;i<40;i++)
		{
			Space space = new Space();
			spaces.add(space);
		}
		}
	
	public List<Space> getSpaces() {
		return spaces;
	}
}
