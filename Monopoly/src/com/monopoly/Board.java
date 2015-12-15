package com.monopoly;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {
	
	int BOARD_SQUARE_COUNT=40;
	List<Square> squares = new ArrayList<>();
	
	public Board(){
		readBoard();
	}//end Board constructor
	
	public void readBoard(){
		try {
			List<String> lines = Files.readAllLines(Paths.get("config/BoardInfo.prop"));
			for (String line : lines) {
				squares.add(createSquare(line));
			}//end for each
			
			Iterator<Square> squareIter = squares.iterator();
			int currentSquare=0;
			while(squareIter.hasNext()){
				Square square = squareIter.next();
				if(squareIter.hasNext())
					square.setNextSquare(squares.get(currentSquare+1));
				else
					square.setNextSquare(squares.get(0));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end readBoard
	
	public Square createSquare(String line){
		
		Square newSquare = null;
		String[] arraySplit = line.split(",");
		if (arraySplit.length==2){				
			String id = arraySplit[0].split(":")[1];
			 String squareType = arraySplit[1].split(":")[1];
			newSquare = new Square(id,squareType);
		}//end if
		else if (arraySplit.length==3){
			 String id = arraySplit[0].split(":")[1];
			 String squareType = arraySplit[1].split(":")[1];
			 int price = Integer.parseInt(arraySplit[2].split("=")[1]);
			 newSquare = new Square(id,squareType,price);
		}//end else if
		else if (arraySplit.length>3){
			 String id = arraySplit[0].split(":")[1];
			 String squareType = arraySplit[1].split(":")[1];
			 int price = Integer.parseInt(arraySplit[2].split("=")[1]);
			 int rent = Integer.parseInt(arraySplit[3].split("=")[1]);
			 String group = arraySplit[4].split("=")[1];
			 newSquare = new Square(id,squareType,price,rent,group);			 
		}//end else if		
		return newSquare;
	}//end createSquare

	public List<Square> getSquares() {
		return squares;
	}//end getSquares
	
	
}//end Board
