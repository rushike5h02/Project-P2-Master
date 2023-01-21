package com.project.ecomerse;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectiontest {
	
	//To connect SQl Database
	Connection connection = null;
	public Connection getConnectionDetails() { //utility
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root", "root");
		} catch (Exception e) {
		e.printStackTrace();
		}
		return connection;
		}


}
