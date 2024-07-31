package com.edu.test;

import java.sql.SQLException;

import com.edu.dao.EmployeeDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateNumException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Employee;

public class EmployeeDAOTest {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = EmployeeDAO.getinstance();
//		try {
//			dao.insertEmployee(new Employee(100, "JAMES", 1500.0, "NY"));
//		} catch (DMLException | DuplicateNumException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			dao.removeEmployee(111);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
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
