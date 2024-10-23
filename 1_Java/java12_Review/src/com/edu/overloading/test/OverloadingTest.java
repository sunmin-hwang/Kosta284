package com.edu.overloading.test;
//vo....table...mapping

class Employee{
	private int empNo;
	private String name;
	private double salary;
	private String address;
	
	//추가...
	public static final double BASIC_SALARY = 100.0;
	public static final String BASIC_ADDR = "NY";
	
	//모든 클래스에서 생성자는 1개 이상
	public Employee(){ }
	
	/*
	 * this 키워드
	 * 1) this.empNo = empNo;
	 * --> 필드와 로컬변수의 이름이 같을 때 둘을 구분하기 위해서 필드앞에 지정
	 * 2) this(empNo, name, BASIC_SALARY, BASIC_ADDR);
	 * --> 생성자 앞의 this는 같은 클래스 내에서 또 다른 생성자(인자값이 꽉 찬 명시적 생성자)를 호출할 때 사용
	 * */
	public Employee(int empNo, String name) {
		this(empNo, name, BASIC_SALARY, BASIC_ADDR);
	}

	public Employee(int empNo, String name, double salary, String address) {
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	
	//필드값을 리턴하는 기능
	public String toString() {
		return empNo + ", " + name + ", " + salary + ", " + address;
	}
}
public class OverloadingTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(7369, "SCOTT", 30000.0, "Texas");
		Employee e2 = new Employee(7521, "SCOTT", 30000.0, "Texas");
		/*
		 * 생성자 오버로딩
		 * 필수정보만으로 객체생성을 할 수 있어애 한다.
		 * 객체를 생성할 때 인자값을 달리 입력해서 객체생성하는 기법
		 * */
		Employee e3 = new Employee(7899, "BLACK");
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

}
