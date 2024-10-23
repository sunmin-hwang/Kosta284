package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee{
	private String nameOfBoss;

	public Secretary() {
		super();
	}

	public Secretary(String nameOfBoss) {
		super();
		this.nameOfBoss = nameOfBoss;
	}
	
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) {
		super(name, salary, birthDate);
		this.nameOfBoss = nameOfBoss;
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + " [nameOfBoss] : " + nameOfBoss;
	}
	
	public String toString() {
		return super.getDetails() + " [nameOfBoss] : " + nameOfBoss;
	}
}
