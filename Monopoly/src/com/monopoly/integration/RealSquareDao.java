package com.monopoly.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.monopoly.squares.Square;

public class RealSquareDao {
	private static String url = "jdbc:mysql://monopoly-db2.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/Monopoly";
	private static String user = "improving";
	private static String pw = "improving";
	private static Connection conn;

	static {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RealSquareDao() {
		// TODO Auto-generated constructor stub
	}

	public Square getSquareByPosition(int i) {
		try {
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Monopoly.PROPERTIES where Position = "+i);
			res.first();
			
			String name = res.getString("Name");
			res.close();
			st.close();
			
			return Square.valueOf(name);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		return null;
	}

}
