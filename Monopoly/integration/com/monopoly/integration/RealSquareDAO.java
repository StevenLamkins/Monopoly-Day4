package com.monopoly.integration;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monopoly.Square;
import com.mysql.jdbc.Connection;

public class RealSquareDAO
{
	
	public void downloadDriver()
	{
		try
		
		{
			Class.forName("");
			
		}
		catch(Exception x)
		{
			System.out.println("Unable to load the driver class!");
		}
		
		
		Connection dbConnection = null;
		String url = "monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly";
		String sql = "SELECT * FROM Monopoly.PROPERTIES where Position = 40;";
		
		try
		{
			dbConnection = DriverManager.getConnection(url, "loginName", "Password");
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
//			while(rs.next())
//			{
//				String name = rs.getString("Name");
//				float salary = rs.getFloat("Salary");
//				System.out.println(name + ": $" + salary);
//			}
		}
		catch(SQLException x)
		{
			System.out.println("Couldn't get the connection");
		}
	}

	public Square getSquareByPosition(int position) {
		// TODO Auto-generated method stub
		return square;
	}
		
}

