package com.edu.statictest;
/*
  static한 변수는 생성된 객체들에서 공유하는 값이다.!!!
 */
class Car{
	int serialNumber;  //field
	static int counter ; //static V
	
	Car(){
		counter++;
		serialNumber=counter;
	}
	
	
}
public class StaticExamTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("===== field Value ======");
		System.out.println(car1.serialNumber);//1
		System.out.println(car2.serialNumber);//2
		System.out.println(car3.serialNumber);//3
		
		System.out.println("===== static Value ======");
		System.out.println(car1.counter);//3
		System.out.println(car2.counter);//3
		System.out.println(car3.counter);//3
		System.out.println(Car.counter);//3
	}
}


















