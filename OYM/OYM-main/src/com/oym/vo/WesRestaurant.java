package com.oym.vo;

import java.util.ArrayList;
/**
 * @author OYM
 * Restaurant를 상속받은 자식 클래스
 */
public class WesRestaurant extends Restaurant{
	
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
	
	public WesRestaurant(String name, 
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
		add(new Menu("스테이크", 70000, "Main", "스테이크입니다."));
		add(new Menu("크림파스타", 15000, "Main", "게살 크림파스타입니다."));
		add(new Menu("샐러드", 16000, "Main", "샐러드입니다."));
		add(new Menu("사이다", 2000, "side", "사이다입니다."));
	}};
}
