package com.monopoly.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monopoly.squares.Square;

public class RealSquareDao {
	
	private Connection dbConnection = null;
	private String url = "jdbc:mysql://monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly";
	private String sqlPropertyByName = "SELECT * FROM PROPERTIES WHERE NAME = '";
	private String sqlPropertyByPos = "SELECT * FROM PROPERTIES WHERE POSITION = ";
	private Statement stmt;
	
	public Square getSquareByName(String name) {
		try{
			
			dbConnection = DriverManager.getConnection(url,"improving","improving");
			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlPropertyByName + name + "'");
			rs.first();
			int position = rs.getInt("position");
			return new Square(position-1);
			
		} catch( SQLException x ) {
			
			System.out.println("Couldn't get connection!");
			x.printStackTrace();
			return null;
			
		}
	}

	public Square getSquareByPosition(int position) {
		try{
			
			dbConnection = DriverManager.getConnection(url,"improving","improving");
			stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlPropertyByPos + position);
			rs.first();
			String name = rs.getString("name");
			return new Square(position-1);
			
		} catch( SQLException x ) {
			
			System.out.println("Couldn't get connection!");
			x.printStackTrace();
			return null;
			
		}
	}

}
