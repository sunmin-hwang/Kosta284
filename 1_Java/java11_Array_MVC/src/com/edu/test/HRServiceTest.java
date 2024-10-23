package com.edu.test;

import com.edu.service.HRService;
import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRServiceTest {

	public static void main(String[] args) {
		HRService service = new HRService(5);

		Engineer e1 = new Engineer("En1", 30000.0, "Java", new MyDate(1998, 1, 1));
		Engineer e2 = new Engineer("En2", 45000.0, "Python", new MyDate(1997, 3, 11));
		Engineer e3 = new Engineer("En3", 53000.0, "AI", new MyDate(1990, 2, 1));

		SalesMan s = new SalesMan("Sal", 56666, 1000, new MyDate(1992, 3, 1));

		// 서비스 기능 호출..
		
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);
		
		service.printEmployee();

		service.addEmployee(s);
		
		service.printEmployee();
		
		service.updateEmployee(new Engineer("En3", 430000.0, "C", new MyDate(1990, 2, 1)));
		service.printEmployee();
		
		service.updateEmployee(new SalesMan("Sal", 60000, 2000, new MyDate(1992, 3, 1)));
		service.printEmployee();
		
		System.out.println(service.searchEmployee("En1").getDetails());
	}

}
