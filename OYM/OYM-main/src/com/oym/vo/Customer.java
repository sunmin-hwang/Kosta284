package com.oym.vo;
/**
 * @author OYM
 * 고객의 정보를 저장하는 클래스
 */
public class Customer{
	
	/**
	 * 아이디
	 */
	private String id;
	/**
	 * 비밀번호
	 */
	private String pw;
	/**
	 * 고객 이름
	 */
	private String name;
	/**
	 * 고객 주소
	 */
	private String address;
	/**
	 * 고객이 선호하는 음식 종류
	 */
	private String favorite;
	/**
	 * 고객의 나이대
	 */
	private int age;
	/**
	 * 고객의 성별
	 */
	private boolean isMan;
/**
 * 
 * @param id 아이디
 * @param pw 비밀번호
 * @param name 이름
 * @param address 주소
 * @param favorite 선호하는 음식 종류
 * @param age 나이대
 * @param isMan 성별
 */
	public Customer(String id, String pw, String name, String address, String favorite, int age, boolean isMan) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.favorite = favorite;
		this.age = age;
		this.isMan = isMan;
	}
	/**
	 * 
	 * @return 비밀번호
	 */
	public String getPw() {
		return pw;
	}
	/**
	 * 
	 * @return 아이디
	 */
	public String getId() {
		return id;
	}
/**
 * 
 * @param pw 비밀번호
 */
	public void changePw(String pw) {
		this.pw = pw;
	}
/**
 * 
 * @return 이름
 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return 주소
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 
	 * @return 선호하는 음식 종류
	 */
	public String getFavorite() {
		return favorite;
	}
/**
 * 
 * @param favorite 선호하는 음식 종류
 */
	public void changeFavorite(String favorite) {
		this.favorite = favorite;
	}
/**
 * 
 * @param address 주소
 */
	public void changeAddress(String address) {
		this.address = address;
	}
/**
 * 
 * @return 나이
 */
	public int getAge() {
		return age;
	}
/**
 * 
 * @return 성별
 */
	public boolean isMan() {
		return isMan;
	}
	/**
	 * 고객의 정보를 리턴하는 기능
	 */
	@Override
	public String toString() {
		return "id : " + id + ", pw : " + pw + ", 이름 : " + name + ", 주소 : " + address + ", 선호 카테고리 : " + favorite
				+ ", 연령대 : " + age + ", 성별 : " + (isMan ? "남자" : "여자");
	}
	

	
}
