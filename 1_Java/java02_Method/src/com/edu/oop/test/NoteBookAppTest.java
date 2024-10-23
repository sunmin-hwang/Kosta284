package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 1. NoteBook 객체생성 n
 *    == NoteBook의 멤버(4)를 메모리에 올린다.
 * 2. 접근
 *    필드 --> 값할당
 *    메소드 --> 호출
 * */
public class NoteBookAppTest {

	public static void main(String[] args) {
		//객체 생성 코드...
		NoteBook n;//참조변수(reference variable)
		n = new NoteBook();//주소값 할당
		
		n.brand = "LG Gram";
		n.price = 1750000.0;
		n.serialNumber = 1768;
		
		n.printNoteBookInfo();
		System.out.println(n);
		////////////////////////
		
		NoteBook n2;
		n2 = new NoteBook();
		
		n2.serialNumber = 222;
		n2.brand = "HP";
		n2.price = 1350000.0;
		
		n2.printNoteBookInfo();
		System.out.println(n2);
		//주소값이 다르면 다른 객체
	}

}
