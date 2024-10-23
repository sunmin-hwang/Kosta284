package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
		//Heterogeneous Collection
		Employee[] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 1 ), "Java", 100),
				new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3), "James"),
				new Manager("James2", 30000.0, new MyDate(1999, 3, 1), "IT2"),
				new Engineer("Tomas2", 45000.0, new MyDate(1997, 5, 12 ), "Java2", 300)
		};
		
		
		/*
		 for문과 instanceof, Object Casting, Virtual Method Invocation 전부 다 사용
		
		 James 부서를 "개발부" 로 수정
		 Tomas 기술을 "AI"기술로 수정
		 Peter Boss의 이름을 "Gosling"으로 수정
		 
		 수정된 정보를 출력
		 */
		for(Employee e : employees) System.out.println(e);
		System.out.println("===================================================");
		
		
		/*
		 1step
		 updateManager(Manager m) {}
		 updateEngineer(Engineer eg) {}
		 
		 
		 2step
		 updateEmployee(Manager m) {}
		 updateEmployee(Engineer eg) {}
		 
		 3step
		 updateEmployee(Employee e) {
		    if(e instanceof Manager){ }
		    if(e instanceof Engineer){ }
		 }
		 */
		for(Employee e : employees) {
			if(e instanceof Manager) ((Manager)e).changeDept("개발부");
			if(e instanceof Engineer) ((Engineer)e).changeTect("AI");;
			if(e instanceof Secretary) ((Secretary)e).changeNameOfBoss("Gosling");
		}
		
		for(Employee e : employees) System.out.println(e);
	}

}
