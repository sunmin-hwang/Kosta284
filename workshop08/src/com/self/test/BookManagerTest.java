package com.self.test;

import com.self.service.BookManager;
import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;
/**
 * <pre>
 * {@code
 *  Book에 관련된 기능을 호출하고 출력하는 클래스
 * }
 * 
 * </pre>
 * 
 * 
 * @author SUN
 * @version BookManager Project version 1.0.1
 * @since JDK 17
 * */
public class BookManagerTest {

	/**
	 * 메인클래스
	 * @param args args
	 * */
	public static void main(String[] args) {
		BookManager manager = BookManager.getInstance();
		
		manager.insertBook(new Novel(1, "헤드퍼스트", "캐시 시에라", "한빛미디어", 42000.0, false));
		manager.insertBook(new Novel(11, "헤드퍼스트", "버트 베이츠", "두빛미디어", 24000.0, true));
		manager.insertBook(new Magazine(2, "포브스", "홍승표", "중앙일보에스", 3000.0, "2024.6"));
		manager.insertBook(new Magazine(22, "Time", "누굴까", "한빛미디어", 2000.0, "2023.7"));
		System.out.println("========모든 Book들의 정보 가져오기==========");
		for(Book book : manager.getAllBook()) {
			if(book == null) break;
			System.out.println(book);
		}
		
		System.out.println("========isbn이 11인 Book의 정보 가져오기==========");
		System.out.println(manager.searchBookByIsbn(11));
		
		System.out.println("========title이 헤드퍼스트인 Book들의 정보 가져오기==========");
		for(Book book : manager.searchBookByTitle("헤드퍼스트")) {
			if(book == null) break;
			System.out.println(book);
		}
		
		System.out.println("========publisher가 한빛미디어인 Book들의 정보 가져오기==========");
		for(Book book : manager.searchBookByPublisher("한빛미디어")) {
			if(book == null) break;
			System.out.println(book);
		}
		
		System.out.println("========가격이 3000원 이상 25000이하인 Book들의 정보 가져오기==========");
		for(Book book : manager.searchBookByPrice(3000, 25000)) {
			if(book == null) break;
			System.out.println(book);
		}
		
		System.out.println("========Book들의 가격의 총 합과 평균 구하기==========");
		System.out.println("총합 : " + manager.getSumPriceOfBooks());
		System.out.println("평균 : " + manager.getAvgPriceOfBooks());
	}

}
