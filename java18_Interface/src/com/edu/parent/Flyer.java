package com.edu.parent;
/*
 * 인터페이스는 추상메소드의 집합 + public static final 상수값
 * ==
 * public abstract 메소드와 public static final 상수값으로 구성됨
 * Template 기능위주의 모듈...
 * 필드는 제공되지 않는다.
 * */
public interface Flyer {
	/*public static final*/ int MAX_SPEED = 200; // public static final이 무조건 앞에 생략되어져있다.
	
	//public abstract void fly() { }  (X)
	public abstract void fly();
	void land(); // public abstract이 무조건 앞에 생략되어져 있다.(인터페이스이기 때문에)
	void takeOff();
}
