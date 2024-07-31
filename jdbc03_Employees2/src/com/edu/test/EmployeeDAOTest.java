package com.edu.test;

import java.sql.SQLException;

import com.edu.dao.EmployeeDAO;
import com.edu.exception.DuplicateNumException;
import com.edu.vo.Employee;

public class EmployeeDAOTest {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = EmployeeDAO.getinstance();
		dao.insertEmployee(new Employee(000, "JAMES", 1500.0, "NY"));
		
//		System.out.println(dao.selectEmployee(111));
//		System.out.println("==========================================");
//		dao.selectEmployee().forEach(System.out::println);
//		
//		System.out.println("\n==========================================\n");
//		
//		dao.updateEmployee(new Employee(111, "JAMES", 1200.0, "NY"));
//		
//		System.out.println(dao.selectEmployee(111));
//		System.out.println("==========================================");
//		dao.selectEmployee().forEach(System.out::println);
//		
//		System.out.println("\n==========================================\n");
//		
//		dao.removeEmployee(222);
//		dao.selectEmployee().forEach(System.out::println);
	}
	
}
