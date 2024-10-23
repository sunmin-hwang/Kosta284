package com.edu.test;

import com.edu.child.Child;
import com.edu.parent.Parent;

public class AccessModifierTest {

	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println("=========Parent의 함수 호출입니다.============");
		p.access();
		
		Child c = new Child();
		System.out.println("=========Child의 함수 호출입니다.============");
		c.childAccess();
		System.out.println("=========Overriding된 함수호출=============");
		c.access();
	}

}
