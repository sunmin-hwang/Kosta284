package com.edu.test;

import java.sql.SQLException;

import com.edu.dao.EmployeeDAO;
import com.edu.vo.Employee;

public class EmployeeDAOTest {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = EmployeeDAO.getinstance();
//		dao.insertEmployee(new Employee(111, "JAMES", 1500.0, "NY"));
		dao.insertEmployee(new Employee(222, "Tomas", 800.0, "Brandon"));
//		dao.insertEmployee(new Employee(333, "PAPAPA", 2500.0, "PARIS"));
//		dao.insertEmployee(new Employee(444, "KIM", 1900.0, "KOREA"));
		
		System.out.println(dao.selectEmployee(111));
		System.out.println("==========================================");
		dao.selectEmployee().forEach(System.out::println);
		
		System.out.println("\n==========================================\n");
		
		dao.updateEmployee(new Employee(111, "JAMES", 1200.0, "NY"));
		
		System.out.println(dao.selectEmployee(111));
		System.out.println("==========================================");
		dao.selectEmployee().forEach(System.out::println);
		
		System.out.println("\n==========================================\n");
		
		dao.removeEmployee(222);
		dao.selectEmployee().forEach(System.out::println);
	}
	
}
