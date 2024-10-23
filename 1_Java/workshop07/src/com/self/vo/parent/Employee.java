package com.self.vo.parent;

import com.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
	public Employee() {
		super();
	}

	public Employee(String name, MyDate birthDate, double salary) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}

	public void upgradeSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return name + ", " + salary + ", " + birthDate;
	}
}
