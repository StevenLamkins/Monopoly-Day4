package com.monopoly;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
				
				String id = line.split(",")[0].split(":")[0];
				String squareType = line.split(",")[1].split(":")[1];
				
				Square newSquare = new Square(id,squareType);
				squares.add(newSquare);
			}//end for each
		} catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end readBoard

	public List<Square> getSquares() {
		return squares;
	}
	
	
}//end Board
