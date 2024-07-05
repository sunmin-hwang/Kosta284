package com.edu.datatype.test;

public class DataTypeTest {

	public static void main(String[] args) {
		//local 변수는 기본값이 없다. -> 반드시 초기화 후 사용
		float salary = 100;
		System.out.println(salary);
		
		//long, float, double 세가지 타입은 값 뒤에 무조건 데이터 타입이 지정
		double salary1 = 100.0;
		System.out.println(salary1);
		
		float salary2 = 100.0f;
		System.out.println(salary2);
		
		long salary3 = 1230000L;
		System.out.println(salary3);
		System.out.println("=================================");
		
		short a, b;
		a = 1;
		b = 2;
		//int 이하의 값에서 사칙연산이 일어나면 int형으로 변환
		short c = (short)(a+b);
		System.out.println(c);
		System.out.println("=================================");
		
		//실제값(literal value)가 들어가면 값이 들어가고 변수가 들어가면 타입 비교가 됨
		int x = 24;
		byte d = (byte) x;
		byte d1 = 24;
		System.out.println(d);
		System.out.println(d1);
	}

}
