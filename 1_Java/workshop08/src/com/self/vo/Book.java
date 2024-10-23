package com.self.vo;
/**
 * <pre>
 * {@code
 *  책의 정보를 저장하는 클래스
 * }
 * 
 * </pre>
 * 
 * 
 * @author SUN
 * @version BookManager Project version 1.0.1
 * @since JDK 17
 */
public class Book {
	/**
	 * 책의 고유번호
	 * */
	private int isbn;
	/**
	 * 책의 제목
	 * */
	private String title;
	/**
	 * 책의 저자
	 * */
	private String author;
	/**
	 * 책의 출판사
	 * */
	private String publisher;
	/**
	 * 책의 가격
	 * */
	private double price;
	
	/**
	 * Book의 기본생성자
	 * */
	public Book() {
		super();
	}

	/**
	 * Book의 명시적 생성자
	 * @param isbn 책의 고유번호
	 * @param title 책의 제목
	 * @param author 책의 저자
	 * @param publisher 책의 출판사
	 * @param price 책의 가격
	 * */
	public Book(int isbn, String title, String author, String publisher, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	/**
	 * 
	 * 출판사 변경
	 * @param publisher 변경할 출판사
	 */
	public void changePublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * 
	 * 가격 변경
	 * @param price 변경할 가격
	 */
	public void changePrice(double price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return 책의 고유번호 반환
	 */
	public int getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @return 책의 제목 반환
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return 책의 저자 반환
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * 
	 * @return 책의 출판사 반환
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * 
	 * @return 책의 가격 반환
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return 책의 전체 정보 반환
	 */
	@Override
	public String toString() {
		return "isbn : " + isbn + ", title : " + title + ", author : " + author + ", publisher : " + publisher
				+ ", price : " + price;
	}
	
	
	
}
