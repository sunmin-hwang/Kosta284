package com.self.vo;
/**
 * <pre>
 * {@code
 *  책 중 잡지의 정보를 저장하는 클래스
 *  Book class를 상속받고있음
 * }
 * 
 * </pre>
 * 
 * 
 * @author SUN
 * @version BookManager Project version 1.0.1
 * @since JDK 17
 */
public class Magazine extends Book {
	/**
	 * 잡지의 출판일
	 * */
	private String publicationDate;

	/**
	 * Magazine의 기본생성자
	 * */
	public Magazine() {
		super();
	}

	/**
	 * Book의 명시적 생성자
	 * @param isbn 책의 고유번호
	 * @param title 책의 제목
	 * @param author 책의 저자
	 * @param publisher 책의 출판사
	 * @param price 책의 가격
	 * @param publicationDate 잡지의 출판일
	 * */
	public Magazine(int isbn, String title, String author, String publisher, double price, String publicationDate) {
		super(isbn, title, author, publisher, price);
		this.publicationDate = publicationDate;
	}

	/**
	 * 
	 * @return 잡지의 출판일 반환
	 */
	public String getPublicationDate() {
		return publicationDate;
	}
	
	/**
	 * 
	 * @return 잡지의 전체 정보 반환
	 */
	@Override
	public String toString() {
		return super.toString() + ", publicationDate : " + publicationDate.split("\\.")[0] + "년 " + publicationDate.split("\\.")[1] + "월";
	}
}
