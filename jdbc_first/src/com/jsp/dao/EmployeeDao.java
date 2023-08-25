package com.jsp.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import com.jsp.dto.Employee;

public class EmployeeDao {

	public void createTableEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
					"Naveen@208");
			Statement statement = connection.createStatement();
			statement.execute(
					"create table employe1(id int primary key,name varchar(45),phone bigint(10),sal double,email varchar(45),password varchar(45))");
			connection.close();
			System.out.println("Table Created....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Employee saveEmployee(Employee e)
	{
		//Register or Load The Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the Connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","Naveen@208");
			
			//Establish Statement
			PreparedStatement ps=connection.prepareStatement("insert into employe1 values(?,?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2, e.getName());
			ps.setLong(3,e.getPhone());
			ps.setDouble(4,e.getSal());
			ps.setString(5, e.getEmail());
			ps.setString(6, e.getPassword());

			ps.executeUpdate();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;

	}
	public int updateEmployee(Employee e) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","Naveen@208");
			
			PreparedStatement ps=connection.prepareStatement("update employe1 set name=?,phone=?,sal=?,email=?,password=? where id=?");
			
			ps.setString(1, e.getName());
			ps.setLong(2, e.getPhone());
			ps.setDouble(3, e.getSal());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getId());
			
			int res=ps.executeUpdate();
			connection.close();
			System.out.println(res);
			return res;
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}


        public int deleteEmployee(Employee e) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","Naveen@208");
		 PreparedStatement p=connection.prepareStatement("delete from employe1 where id=?");
			p.setInt(1, e.getId());
		
			int res =p.executeUpdate();
		 connection.close();		 
		 System.out.println(res);
		 return res;
		 
		 
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
	 return 0;
        }
        

public List<Employee> getAllEmployee() {
	List<Employee> m = new ArrayList<Employee>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","Naveen@208");
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select * from employe1");
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			long phone = resultSet.getLong(3);
			double sal = resultSet.getDouble(4);
			String email = resultSet.getString(5);
			String password = resultSet.getString(6);

			Employee employee = new Employee();

			employee.setId(id);
			employee.setName(name);
			employee.setPhone(phone);
			employee.setSal(sal);
			employee.setEmail(email);
			employee.setPassword(password);
			m.add(employee);

		}
		connection.close();
	
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return m;
}

public Employee getEmployeeById(int id) {
	Employee employee = new Employee();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud","root","Naveen@208");
		PreparedStatement preparedStatement = connection.prepareStatement("select * from employe1 where id=?");
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id1 = resultSet.getInt(1);
			String name = resultSet.getString(2);
			long phone = resultSet.getLong(3);
			double sal = resultSet.getDouble(4);
			String email = resultSet.getString(5);
			String password = resultSet.getString(6);

			employee.setId(id1);
			employee.setName(name);
			employee.setPhone(phone);
			employee.setSal(sal);
			employee.setEmail(email);
			employee.setPassword(password);

		}
		connection.close();

	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return employee;

}



public Employee login(String email, String password) {
	Employee employee = new Employee();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_crud", "root",
				"Naveen@208");

		PreparedStatement ps = connection.prepareStatement("select * from employe1 where Email=? and Password=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet resultSet = ps.executeQuery();
		while (resultSet.next()) {

			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setPhone(resultSet.getLong(3));
			employee.setSal(resultSet.getDouble(4));
			employee.setEmail(resultSet.getString(5));
			employee.setPassword(resultSet.getString(6));

		}
		connection.close();

	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return employee;

}

}

