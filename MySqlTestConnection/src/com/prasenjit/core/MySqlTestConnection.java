package com.prasenjit.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlTestConnection {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prasenjit","root","admin");
		System.out.println("Connection Successful!");
	}

}
