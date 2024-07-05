package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 *생성자
 *::
 *객체가 생성될때마다 구동하는 것
 * */
public class NoteBookAppTest3 {

	public static void main(String[] args) {
		//객체 생성 코드...
		//객체 생성시 class는 type으로 작동한다.
		NoteBook n = new NoteBook();//NoteBook() --> 생성자
		NoteBook n2 = new NoteBook(999,"samsung",2200000.0);
		
		System.out.println(n.getNoteBookInfo());
		System.out.println(n2.getNoteBookInfo());
	}

}
