package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent {
	//자식만의 메소드
	public void childAccess() {
		System.out.println(publicField);
		System.out.println(protectedField);
		System.out.println("defaultField, privateField는 접근할수 없습니다.");
	}
	
	@Override
	public void access() {
		super.access();
		//추가..고쳐쓴다.
		System.out.println("부모에 접근가능한 필드 :: " + publicField);
		System.out.println("부모에 접근가능한 필드 :: " + protectedField);
	}
}
