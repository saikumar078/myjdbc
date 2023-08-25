package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Demo2 {
		public static void main(String[] args) {
			try {
				//installtion of Drivers 
		DriverManager.registerDriver(new Driver());
				
				//etablishing the connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Naveen@208");
				
				//establishing the statements
				Statement statement= connection.createStatement();
				System.out.println(statement.execute("update jdbc_first_geaa01.Employee")); 
			
				//System.out.println(statement.execute("drop table jdbc_first_geaa01.use\"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
