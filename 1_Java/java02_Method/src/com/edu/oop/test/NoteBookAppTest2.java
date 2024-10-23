package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 필드에 직접 값을 할당하지 않고
 * setXxxx(o,o,o)기능을 호출해서 필드초기화를 구동
 * */
public class NoteBookAppTest2 {

	public static void main(String[] args) {
		//객체 생성 코드...
		//객체 생성시 class는 type으로 작동한다.
		NoteBook n = new NoteBook();
		n.setNoteBookField(123, "LG Gram", 1700000.0);
		//n.printNoteBookInfo();
		System.out.println(n.getNoteBookInfo());
		
	}

}
