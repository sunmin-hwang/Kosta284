package com.oym.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oym.exception.NothingException;
import com.oym.vo.Customer;
import com.oym.vo.Restaurant;
/**
 * CustomerServiceImpl의 선언부를 강제하는 인터페이스
 */
public interface CustomerService {
	
	/**
	 * 회원가입을 하는 기능
	 * @param customer 회원가입할 사용자의 정보
	 * */

	void register(Customer customer);
	/**
	 * 특정한 회원을 찾아주는 기는
	 * @param id 찾고자 하는 사용자의 id
	 * @return 전달받은 id와 일치하는 사람의 회원정보
	 * @throws NothingException 
	 * */
	Customer findCustomer(String id) throws NothingException;
	/**
	 * 사용자의 정보를 수정하는 기능
	 * password와 address와 선호하는 category만 변경 가능
	 * @param user 수정할 사용자의 정보
	 * @throws NothingException 
	 * */
	void updateCustomer(Customer user) throws NothingException;
	/**
	 * 사용자의 정보를 삭제하는 기능
	 * @param id 회원탈퇴할 사용자의 정보
	 * @throws NothingException 
	 * */
	void deleteCustomer(String id) throws NothingException;
	
	
	/**
	 * 모든 맛집의 정보를 보여주는 기능
	 * @return 프로그램에 저장된 모든 맛집들의 리스트
	 * */
	ArrayList<Restaurant> findAllRestaurant();
	/**
	 * 사용자가 궁금해하는 category에 속하는 맛집들을 보여주는 기능
	 * @return 사용자가 궁금해하는 category에 속하는 맛집들의 리스트
	 * @param category 사용자가 검색한 카테고리
	 * */
	ArrayList<Restaurant> findRestaurantByCategory(String category);
	/**
	 * 사용자가 궁금해하는 지역에 속하는 맛집들을 보여주는 기능
	 * @return 사용자가 궁금해하는 지역에 속하는 맛집들의 리스트
	 * @param location 사용자가 검색한 지역
	 * @throws NothingException 
	 * */
	ArrayList<Restaurant> findRestaurantByLocation(String location) throws NothingException;
	/**
	 * 사용자가 궁금해하는 가게이름이 포함된 맛집들을 보여주는 기능
	 * @return 사용자가 궁금해하는 가게이름이 포함된 맛집들의 리스트
	 * @param name 사용자가 검색한 가게이름
	 * @throws NothingException 
	 * */
	ArrayList<Restaurant> findRestaurantByName(String name ) throws NothingException;
	
	
	/**
	 * 사용자가 회원가입했을때 입력한 주소 근처의 맛집들을 추천해주는 기능
	 * @param customer 로그인한 사용자의 정보
	 * @return 사용자 근처의 맛집 리스트
	 * @throws NothingException 
	 * */
	List<Restaurant> recommendRestaurantByAddress(Customer customer) throws NothingException;
	/**
	 * 사용자가 선호하는 종류의 맛집들을 추천해주는 기능
	 * @param customer 로그인한 사용자의 정보
	 * @return 사용자가 선호하는 종류의 맛집 리스트
	 * @throws NothingException 
	 * */
	List<Restaurant> recommendRestaurantByCategory(Customer customer) throws NothingException;

	/**
	 * 리뷰에 작성된 별점들의 평균이 높은순으로 맛집을 추천해주는 기능
	 * @return 리뷰에 작성된 별점들의 평균이 높은순으로 정렬된 맛집 리스트
	 * */
	Map<Restaurant, Double> recommendRestaurantByRating();
	/**
	 * 작성된 리뷰가 많은 순으로 맛집을 추천해주는 기능
	 * @return 작성된 리뷰가 많은 순으로 정렬된 맛집 리스트
	 * */
	List<Restaurant> recommendRestaurantByReviews();

}
