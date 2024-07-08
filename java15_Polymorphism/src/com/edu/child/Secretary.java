package com.edu.child;

import com.edu.parent.Employee;

public class Secretary extends Employee{
	private String nameOfBoss;

	public Secretary() {
		super();
	}

	public Secretary(String nameOfBoss) {
		super();
		this.nameOfBoss = nameOfBoss;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails();
	}
}
