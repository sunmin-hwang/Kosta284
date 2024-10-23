package com.edu.parent;
/*
 * 상속관계에서 Access Modifier관계를 정리해보겠다.
 * 부모 클래스
 * 
 * public > protected > [default] > private
 * */
public class Parent {
	public String publicField = "publicFiled";
	protected String protectedField = "protectedFiled";
	String defaultField = "defaultFiled";
	private String privateField = "privateFiled";
	
	public void access() {
		System.out.println("Access Modifier Test...");
		System.out.println(publicField);
		System.out.println(protectedField);
		System.out.println(defaultField);
		System.out.println(privateField);
	}
}
