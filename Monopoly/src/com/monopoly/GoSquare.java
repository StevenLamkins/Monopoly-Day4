package com.monopoly;

public class GoSquare extends Square {

	public GoSquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void landOn (Player player) {
		player.setMoney(player.getMoney()  + 200);
		
	}
}
