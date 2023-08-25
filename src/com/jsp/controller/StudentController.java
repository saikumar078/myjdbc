package com.jsp.controller;


import java.sql.SQLException;

import com.jsp.Dao.StudentDao;
import com.jsp.Dto.Student;

public class StudentController {
	public static void main(String[] args) throws SQLException{
		StudentDao dao = new StudentDao();
//		Student student=new Student();
		dao.createTable();
//		
//		student.setName("donseenu");
//		student.setMblNo(123654789l);
		
//		dao.update(student);
		
//		dao.save(student);
//		dao.delete(10);
	}
}
