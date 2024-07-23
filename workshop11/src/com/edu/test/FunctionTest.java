package com.edu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.edu.service.EmployeeService;
import com.edu.vo.Employee;

public class FunctionTest {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "SCOTT", 30000.0));
		employees.add(new Employee(2, "ADAMS", 25000.0));
		employees.add(new Employee(3, "SMITH", 21000.0));
		employees.add(new Employee(4, "KING", 50000.0));
		
		employees.forEach(x->{
			x.setSalary(x.getSalary() + x.getSalary() * 0.15);
			System.out.println(x);
		});
		
		System.out.println("/////////////////////////////////");
		
		Consumer<Employee> c = e -> System.out.println(e);
		service.raiseSalary(employees, c);
		//service.raiseSalary(employees, e -> System.out.println(e));
	}
}
