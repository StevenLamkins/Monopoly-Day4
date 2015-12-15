package com.monopoly;

public class Square {

	String id;
	String squareType;
	int price;
	int rent;
	String group;
	
	public Square(String id,String squareType, int price,int rent,String group){
		this.id=id;
		this.squareType =squareType;
		this.price = price;
		this.rent = rent;
		this.group = group;
	}//end Square Constructor
	
	public Square(String id,String squareType){
		this.id=id;
		this.squareType =squareType;		
	}//end Square Constructor
	
	public Square(String id,String squareType, int price){
		this.id=id;
		this.squareType =squareType;
		this.price = price;		
	}//end Square Constructor
	
	public String getId(){
		return id;
	}
	
}//end Square
