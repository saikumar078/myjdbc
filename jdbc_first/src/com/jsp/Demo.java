package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
public static void main(String[] args) {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Naveen@208");
		System.out.println(connection);
		
		
		Statement statement=connection.createStatement();
		System.out.println(statement);
			} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
			
				e.printStackTrace();
			}
}
}
