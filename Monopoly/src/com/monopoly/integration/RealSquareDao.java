package com.monopoly.integration;

import java.sql.DriverManager;

import com.monopoly.LotSquare;
import com.monopoly.Square;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RealSquareDao {
	
	private Connection dbConnection = null;
	private String url = "jdbc:mysql://monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly";
	private String sqlPropertyByPos = "SELECT * FROM PROPERTIES WHERE POSITON = ?";
	private Statement stmt;
	private PreparedStatement pstmt;
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception x){
			System.out.println("Unable to load the driver class!");
		}
	}
	public RealSquareDao(){
		try{
			dbConnection = DriverManager.getConnection(url, "improving", "improving");
		}
		catch(SQLException x){
			System.out.println("Couldn't get connection!");
		}
	}
	public Square getSquareByPosition(int position){
		Square square = null;
		
		try{
			pstmt = dbConnection.prepareStatement(sqlPropertyByPos);
			pstmt.setInt(1, position + 1);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String name = rs.getString("NAME");
			int price = rs.getInt("price");
			int rent = rs.getInt("rent");
			
			square = new LotSquare(name, price, rent);
		}
		catch(SQLException x){
			System.out.println("failed to execute statement" + position);
		}

		return square;
		
	}
}
