package com.oym.vo;

import java.util.ArrayList;
import java.util.List;
/**
 * @author OYM
 * Restaurant를 상속받은 자식 클래스
 */
public class ChiRestaurant extends Restaurant{
	
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
	public ChiRestaurant(String name, 
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
		add(new Menu("짜장면", 8000, "Main", "짜장면."));
		add(new Menu("짬뽕", 9000, "Main", "짬뽕입니다."));
		add(new Menu("탕수육", 18000, "Main", "탕수육입니다."));
		add(new Menu("콜라", 2000, "side", "콜라입니다."));
	}};

}
