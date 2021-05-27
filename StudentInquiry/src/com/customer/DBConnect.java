package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {//sql connection
	
	private static String url = "jdbc:mysql://localhost:3306/onlinehelpdesk";
	private static String userName = "notRoot";
	private static String password = "root123";
	private static Connection con;

	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
	}
}
