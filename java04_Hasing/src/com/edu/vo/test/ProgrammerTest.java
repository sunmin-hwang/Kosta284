package com.edu.vo.test;

import com.edu.vo.NoteBook;
import com.edu.vo.Programmer;

/*
 * 1. 객체생성
 * 2. 메소드 호출
 */
public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. james라는 개발자를 생성	
		 *    tomas라는 개발자를 생성
		 * 2. james가 HP노트북을 구매
		 *    tomas가 LG노트북을 구매
		 *    
		 * 3. tomas가 구매한 노트북의 가격과 브랜드명을 출력
		 * 4. james의 연봉을 출력
		 * 5. tomas의 급여를 인상....최종적인 연봉을 출력
		 */
		//1
		Programmer james = new Programmer("James", "Java", 300000.0f, "서울", 10000);
		Programmer tomas = new Programmer("Tomas", "Python", 200000.0f, "종로", 5000);
		
		//2
		james.buyNoteBook(new NoteBook(111, "HP", 1700000));
		tomas.buyNoteBook(new NoteBook(222, "LG", 1650000));
		
		//3
		System.out.println("====== Tomas가 구입한 노트북 정보입니다 =============");
		NoteBook tomasNoteBook = tomas.getNoteBook();
		System.out.println(tomasNoteBook.price + "," + tomasNoteBook.brand);
		
		//4
		System.out.println("\n====== James의 연봉 정보입니다 =============");
		System.out.println(james.getAnnualSalary());
		
		//5
		System.out.println("\n====== Tomas의 급여인상분을 반영한 연봉 정보입니다 =============");
		tomas.raiseSalary(50000);
		System.out.println(tomas.getAnnualSalary());
	}

}
