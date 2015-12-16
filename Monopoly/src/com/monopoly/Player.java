package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.MonopolyGame.Token;
import com.monopoly.squares.Property;
import com.monopoly.squares.Square;

public class Player {

	private List<Die> dice;
	private Square square;
	private List<Property> properties;
	private Token token;
	private int money;
	
	public Player(Square square, Token token, List<Die> dice) {
		this.properties = new ArrayList<>();
		this.money = 1500;
		this.dice = dice;
		this.square = square;
		this.token = token;
	}

	@Override
	public String toString()
	{
		return token.toString();
	}
	
	public int getPosition(){
		return square.getPosition();
	}
	
	public Square getSquare(){
		return square;
	}

	public Token getToken() {
		return token;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int takeTurn() {
		int value = rollDice();
		//System.out.println(getToken() + " rolled " + value);
		int roll = 1;
		while(dice.get(0).getFaceValue() == dice.get(1).getFaceValue() && roll < 3)
		{
			//System.out.println(toString() + " rolled doubles, rolling again");
			int rollValue = rollDice();
			//System.out.println(toString() + " rolled " + rollValue);
			value += rollValue;
			roll++;
		}
		move(value);
		//System.out.println(toString() + " moved to " + getSquare());
		return roll;
	}
	
	public int rollDice() {
		int total = dice.get(0).roll() + dice.get(1).roll();
		return total;
	}

	public int getLastRoll() {
		return dice.get(0).getFaceValue() + dice.get(1).getFaceValue();
	}
	
	public void move(int value) {
		for(int i = 0; i < value; i++)
		{
			if(i > 0)
			{
				square.pass(this);
			}
			square = square.getNextSquare();
		}
		square.landOn(this);
	}

	public void purchase(Property property)
	{
		if(money > property.getValue())
		{
			property.purchase(this);
			setMoney(money - property.getValue());
		}
	}
	
	public List<Property> getProperties() {
		return properties;
	}

	public void pay(Player owner, int rent) {
		
		int amount = rent;
		if(this.getMoney() < rent)
			amount = this.getMoney();
		
		this.setMoney(this.getMoney() - rent);
		owner.setMoney(owner.getMoney() + amount);
	}
	
}
