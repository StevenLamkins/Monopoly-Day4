package com.monopoly.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monopoly.Group;
import com.monopoly.LotSquare;
import com.monopoly.Square;
import com.monopoly.SquareDao;

//monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly 
//username: improving 
//password: improving 
//Query: SELECT * FROM Monopoly.PROPERTIES where Position = 40;
public class RealSquareDao implements SquareDao {

	Connection dbConnection = null;
	String url = "jdbc:mysql://monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly";
	String sql = "SELECT * FROM Monopoly.PROPERTIES where Position = ";
	
	//String sql = "SELECT * FROM Monopoly.PROPERTIES where Position = ?";
	//PreparedStatement pstmt;

	public RealSquareDao() {
		try {
			Class.forName("com.mysqu.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
	}

	public Square getSquareByPosition(int i) {
		Square square = null;
		try {
			dbConnection = DriverManager.getConnection(url, "improving",
					"improving");
			
			Statement stmt = dbConnection.createStatement();

			sql += (i+1);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int rent = rs.getInt("rent");
				String position = rs.getString("position");
				
				
				System.out.println(" Name: " + name + " Price " + price + " Rent " + rent + " Position " + position);
				square = new LotSquare(name, rent, price, Group.DarkBlue);
				System.out.println(square.getName());
			}
			
			
		} catch (SQLException e) {
			System.out.println("Unable to get connection: " + e.getMessage());

		}
		return square;
	}
	


}
