package com.oym.vo;

import java.util.ArrayList;
/**
 * @author OYM
 * Restaurant를 상속받은 자식 클래스
 */
public class JapRestaurant extends Restaurant{

	/**
	 * 명시적 생성자
	 * @param name 가게 이름
	 * @param tel 가게 전화번호
	 * @param location 가게 장소
	 * @param openTime 가게 여는 시간
	 * @param closeTime 가게 닫는 시간
	 * @param reviews 리뷰 리스트
	 * @param menus 메뉴 리스트
	 */
	public JapRestaurant(String name, 
			  String tel,
			  String location,
			  int openTime,
			  int closeTime,
			  ArrayList<Review> reviews,
			  ArrayList<Menu> menus) {
		super(name, tel, location, openTime, closeTime, reviews, menus);
	}
	/**
	 * 메뉴 배열을 생성하고 4가지 메뉴를 넣는다.
	 */
	ArrayList<Menu> menus = new ArrayList<Menu>(){{
		add(new Menu("초밥", 15000, "Main", "초밥입니다."));
		add(new Menu("라멘", 10000, "Main", "라멘입니다."));
		add(new Menu("규동", 11000, "Main", "규동입니다."));
		add(new Menu("콜라", 2000, "side", "콜라입니다."));
	}};

}
