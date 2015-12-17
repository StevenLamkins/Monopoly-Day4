package com.monopoly.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public void roar() throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://monopoly-db.cfku12bwyki0.us-west-2.rds.amazonaws.com:3306/monopoly";
		String user = "root";
		String pw = "improving";
		
		Connection conn = DriverManager.getConnection(url , user, pw);
		Statement st = conn.createStatement();
		//ResultSet rs = st.executeQuery("SELECT * FROM monopoly.");
		
	}
	
	public DBTest() {
		try {
			roar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBTest testBruh = new DBTest();
	}

}
