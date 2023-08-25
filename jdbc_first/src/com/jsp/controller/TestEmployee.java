package com.jsp.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
			
		/*List<Employee> list= dao.getAllEmployee();
		for(Employee employee:list) {
			
			System.out.println("Employee Id:  "+employee.getId());
			System.out.println("Employee Name:  "+employee.getName());
			System.out.println("Employee Phone:  "+employee.getPhone());
			System.out.println("Employee Sal:  "+employee.getSal());
			System.out.println("Employee Email:  "+employee.getEmail());
			System.out.println("Employee Password:  "+employee.getPassword());
			System.out.println("--------------------------------------------");
			
		}*/
		
		
		
		
		/*
		Employee dto=dao.getEmployeeById(2);
		if(dto!=null) {
			System.out.println("Employee Id:  "+dto.getId());
			System.out.println("Employee Name:  "+dto.getName());
			System.out.println("Employee Phone:  "+dto.getPhone());
			System.out.println("Employee Sal:  "+dto.getSal());
			System.out.println("Employee Email:  "+dto.getEmail());
			System.out.println("Employee Password:  "+dto.getPassword());
			
		}
		else
		{
		System.out.println("not found");
		}*/
	
		Scanner sc =new Scanner(System.in);
		System.out.println("enter Email :");
		String email=sc.next();
		System.out.println("enter Password");
		String password=sc.next();
		
		Employee dto=dao.login(email, password);
		
		if(dto!=null && dto.equals(email) && dto.equals(password)) {
			System.out.println("---------------------------------------------");
			System.out.println("Employee Id :" + dto.getId());
			System.out.println("Employee Name :" + dto.getName());
			System.out.println("Employee PhoneNumber :" + dto.getPhone());
			System.out.println("Employee Salary :" + dto.getSal());
			System.out.println("Employee Email :" + dto.getEmail());
			System.out.println("Employee Password :" + dto.getPassword());
			System.out.println("---------------------------------------------");
		} else {
			System.out.println("enter details are inncorrect");
		}
		}
}
