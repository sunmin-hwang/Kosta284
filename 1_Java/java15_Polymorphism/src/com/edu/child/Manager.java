package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee {
	
	private String dept;

	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate);
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}

	public String getDetails() {
		//부모가 물려준 기능을 자식에게 맞게 고쳐썼다..구현부 변경...Method Overriding
		return super.getDetails() + ", " + dept;
	}
	
	public String toString() {
		return super.getDetails() + ", " + dept;
	}
	
	public void manage() {
		System.out.println("Manager...");
	}
}
