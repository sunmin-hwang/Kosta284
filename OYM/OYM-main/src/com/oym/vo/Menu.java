package com.oym.vo;
/**
 * @author OYM
 * 메뉴에 대한 정보를 저장하는 클래스
 */
public class Menu {
	/**
	 * 메뉴 이름
	 */
	private String name;
	/**
	 * 메뉴 가격
	 */
	private int price;
	/**
	 * 하위 분류
	 */
	private String subCategory;
	/**
	 * 메뉴 설명
	 */
	private String summary;
	
	/**
	 * 
	 * @param name 메뉴 이름
	 * @param price 메뉴 가격
	 * @param subCategory 메뉴의 하위 분류 ex)메인 요리, 사이드 요리, 음료
	 * @param summary 메뉴 설명
	 */
	public Menu(String name, int price, String subCategory, String summary) {
		super();
		this.name = name;
		this.price = price;
		this.subCategory = subCategory;
		this.summary = summary;
	}

/**
 * 
 * @return 메뉴이름
 */
	public String getName() {
		return name;
	}

/**
 * 
 * @param name 이름
 */
	public void setName(String name) {
		this.name = name;
	}

/**
 * 
 * @return 가격
 */
	public int getPrice() {
		return price;
	}

/**
 * 
 * @param price 가격
 */
	public void setPrice(int price) {
		this.price = price;
	}

/**
 * 
 * @return 하위분류
 */
	public String getSubCategory() {
		return subCategory;
	}

/**
 * 
 * @param subCategory 하위분류
 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

/**
 * 
 * @return 설명
 */
	public String getSummary() {
		return summary;
	}

/**
 * 
 * @param summary 설명
 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
