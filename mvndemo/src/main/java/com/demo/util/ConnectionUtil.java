package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConnectionUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root", "Vasanth@1761");
		return  connection;
	}
}
