package com.edu.oop.test;

import com.edu.oop.Greet;

//Test 클래스는 실행의 대상이 된다.
/*
 * 1. Greet클래스를 메모리에 올리고==객체생성
 * 2. 멤버에 접근
 *    필드 --> 값할당
 *    메소드 --> 호출
 * */
public class GreetAppTest {

	public static void main(String[] args) {
		Greet g = new Greet();
		g.message = "하이요";
		g.who = "선민";
		
		g.sayHello();//호출
	}

}
