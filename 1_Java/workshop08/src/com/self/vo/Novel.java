package com.self.vo;
/**
 * <pre>
 * {@code
 *  책 중 소설의 정보를 저장하는 클래스
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
public class Novel extends Book {
	/**
	 * 한국소설인지 아닌지 확인하는 변수 한국소설이면 true 외국소설이면 false가 저장됨 
	 * */
	private boolean isKorean;

	/**
	 * Novel의 기본생성자
	 * */
	public Novel() {
		super();
	}

	/**
	 * Book의 명시적 생성자
	 * @param isbn 책의 고유번호
	 * @param title 책의 제목
	 * @param author 책의 저자
	 * @param publisher 책의 출판사
	 * @param price 책의 가격
	 * @param isKorean 한국소설인지 아닌지 확인
	 * */
	public Novel(int isbn, String title, String author, String publisher, double price, boolean isKorean) {
		super(isbn, title, author, publisher, price);
		this.isKorean = isKorean;
	}

	/**
	 * 
	 * @return 한국소설인지 아닌지 반환
	 */
	public boolean getIsKorean() {
		return isKorean;
	}

	/**
	 * 
	 * @return 소설의 전체 정보 반환
	 */
	@Override
	public String toString() {
		if(isKorean) {
			return super.toString() + ", 한국소설";
		}else {
			return super.toString() + ", 외국소설";
		}
		
	}
	
	
}
