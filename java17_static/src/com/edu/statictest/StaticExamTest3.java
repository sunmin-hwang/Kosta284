package com.edu.statictest;
/*
 main이 실행 --->
 객체생성 == 필드 initialization
 */
public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("1.main method block");
	}
	
	//static initialization block(static 초기화 블락)
	static {
		i = 300;
		System.out.println("2. static block....." + i);
	}
}
