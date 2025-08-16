package com.exp_tracker.db;

import java.sql.*;

public class DBConnection {

	public static final String URL = "jdbc:mysql://localhost:3306/exp_tracker";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException{
		return 	DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}
	