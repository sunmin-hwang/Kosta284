package com.self.service;

import com.self.vo.Book;
/**
 * <pre>
 * {@code
 *  Book에 관련된 기능을 담당하는 클래스
 *  책 추가, 조건에 맞는 책 검색, 가격의 총합과 평균을 알려주는 기능이 있음
 * }
 * 
 * </pre>
 * 
 * 
 * @author SUN
 * @version BookManager Project version 1.0.1
 * @since JDK 17
 * */
public class BookManager {
	/**
	 * 전체 책의 수
	 * */
	private int numberOfBook;
	private int idx;
	
	/**
	 * 전체 책의 정보를 저장할 배열
	 * */
	private Book[] books;
	
	/**
	 * BookManager 객체생성
	 * */
	private static BookManager manager = new BookManager();
	
	/**
	 * BookManager의 기본생성자
	 * 책을 담을 수 있는 배열의 크기를 5로 지정
	 * */
	private BookManager() {
		books = new Book[5];
	}
	
	/**
	 * 
	 * @return 만들어진 BookManager 객체를 반환(싱글톤)
	 */
	public static BookManager getInstance() { 
		return manager;
	}
	
	/**
	 * 책의 정보를 저장하는 기능
	 * @param book 저장할 책의 정보
	 */
	public void insertBook(Book book) {
		if(idx < books.length) books[numberOfBook++] = book;
	}
	
	/**
	 * 모든 책의 정보를 반환하는 기능
	 * @return 저장된 모든 책의 정보
	 */
	public Book[] getAllBook() {
		return books;
	}
	
	/**
	 * 해당하는 고유번호의 책을 찾아 정보를 반환하는 기능
	 * @param isbn 찾을 책의 고유번호
	 * @return 해당하는 고유번호의 책의 정보
	 */
	public Book searchBookByIsbn(int isbn) {
		for(Book b : books) {
			if(b == null) break;
			if(b.getIsbn() == isbn) return b;
		}
		return null;
	}
	
	/**
	 * 해당하는 제목의 책들을 모두 찾아 정보를 반환하는 기능
	 * @param title 찾을 책들의 제목
	 * @return 해당하는 제목의 책들의 정보
	 */
	public Book[] searchBookByTitle(String title) {
		idx = 0;
		Book[] tbooks = new Book[numberOfBook];
		for(Book b : books) {
			if(b == null) break;
			if(b.getTitle().equals(title)) tbooks[idx++] = b;
		}
		Book[] rbooks = new Book[idx];
		System.arraycopy(tbooks, 0, rbooks, 0, idx);
		return rbooks;
	}
	
	/**
	 * 해당하는 출판사의 책들을 모두 찾아 정보를 반환하는 기능
	 * @param publisher 찾을 책들의 출판사
	 * @return 해당하는 출판사의 책들의 정보
	 */
	public Book[] searchBookByPublisher(String publisher) {
		idx = 0;
		Book[] pbooks = new Book[numberOfBook];
		for(Book b : books) {
			if(b == null) break;
			if(b.getPublisher().equals(publisher)) pbooks[idx++] = b;
		}
		Book[] rbooks = new Book[idx];
		System.arraycopy(pbooks, 0, rbooks, 0, idx);
		return rbooks;
	}
	
	/**
	 * 특정한 가격 범위 안에 있는 책들을 모두 찾아 정보를 반환하는 기능
	 * @param min 찾을 책들의 가격의 최솟값
	 * @param max 찾을 책들의 가격의 최댓값
	 * @return 특정한 가격 범위 안에 있는 책들의 정보
	 */
	public Book[] searchBookByPrice(int min, int max) {
		idx = 0;
		Book[] pbooks = new Book[numberOfBook];
		for(Book b : books) {
			if(b == null) break;
			if(b.getPrice() <= max && b.getPrice() >= min) pbooks[idx++] = b;
		}
		Book[] rbooks = new Book[idx];
		System.arraycopy(pbooks, 0, rbooks, 0, idx);
		return rbooks;
	}
	
	/**
	 * 저장된 책들의 가격을 모두 합한 값을 반환하는 기능
	 * @return 저장된 책들의 가격을 모두 합한 값
	 */
	public double getSumPriceOfBooks() {
		double sum = 0;
		for(Book b : books) {
			if(b == null) break;
			sum += b.getPrice();
		}
		return sum;
	}
	
	/**
	 * 저장된 책들의 가격의 평균을 반환하는 기능
	 * @return 저장된 책들의 가격의 평균
	 */
	public double getAvgPriceOfBooks() {
		double avg = manager.getSumPriceOfBooks() / numberOfBook;
		return avg;
	}
}
