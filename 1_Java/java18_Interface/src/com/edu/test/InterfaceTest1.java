package com.edu.test;

import com.edu.child.AirPlane;
import com.edu.child.Bird;
import com.edu.parent.Flyer;

public class InterfaceTest1 {

	
	public static void main(String[] args) {
		/*
	       abstract가 조금이라도 있으면 객체생성의 대상이 될 수 없다.
	       대신에 객체생성을 하기 위한 타입은 가능하다.
	       Flyer f = new Flyer();
	    */
		Flyer f = new Bird(); //Polymorphism...부모타입으로 자식객체를 생성
		/*
		   1. Object Casting
		   2. Virtual Method Invocation
		 */
		System.out.println(((Bird) f).layEggs());//1
		f.land();//2
		
		///////////////////////////////////////////////
		
		Flyer f2 = new AirPlane();
		f2.fly();
		f2.land();
		
		Flyer[] f3 = new Flyer[3];
	}

}
