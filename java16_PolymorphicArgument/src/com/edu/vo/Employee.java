package com.edu.vo;
//Super Class...
abstract/*코드의 가독력이 올라간다. 단, 객체생성 불가*/ public class Employee {
	private int empId;
	private String name;
	private String addr;
	private int salary;
	
	public Employee() {	}
	
	public Employee(int empId, String name, String addr, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}

	
	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public int getSalary() {
		return salary;
	}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr
				+ ", salary=" + salary + "]";
	}		
}











