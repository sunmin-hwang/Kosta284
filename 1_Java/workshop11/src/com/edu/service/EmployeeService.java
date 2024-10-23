package com.edu.service;

import java.util.List;
import java.util.function.Consumer;

import com.edu.vo.Employee;

public class EmployeeService {
	public void raiseSalary(List<Employee> list, Consumer<Employee> c) {
		for(Employee e : list) {
			e.setSalary(Math.round(e.getSalary() * 1.15));
			c.accept(e);
		}
	}
}
