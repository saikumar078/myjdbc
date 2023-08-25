package com.jsp.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.Dto.Student;

public class StudentDao {

	public void createTable() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","root");
			Statement statement=connection.createStatement();
			statement.execute("create table Hostel(id int primary key, name varchar(45) ,mblno bigint)");
			
			connection.close();
			System.out.println("table is create");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void save(Student student){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?)");
			preparedStatement.setInt(1,student.getId() );
			preparedStatement.setString(2,student.getName());
			preparedStatement.setLong(3,student.getMblNo());
			preparedStatement.execute();
			System.out.println("data is saved");
			


			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}	
	public void update(Student student){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set name=?,mblno=? where id=10");
			
			preparedStatement.setString(1,student.getName());
			preparedStatement.setLong(2,student.getMblNo());
			
			int res=preparedStatement.executeUpdate();
			System.out.println("data is update");
			
    

			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
	public void delete(int id){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
			preparedStatement.setInt(1, id);
			int res=preparedStatement.executeUpdate();
			System.out.println("data is deleted");
			
    

			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
	
}
