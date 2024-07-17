package com.edu.service;

import com.edu.vo.Employee;

public interface EmployeeService {
	Employee[ ] getAllEmployee(Employee[ ] ea);
	Employee findEmployee(Employee[ ] ea, int empId);
	Employee[ ] findEmployee(Employee[ ] ea, String addr);
	int getAnnualSalary(Employee e);
	int getTotalCost(Employee[ ] ea);
}
