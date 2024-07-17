package com.oym.vo;
/**
 * 리뷰 내용
 */
public class Review {
	
	private String comment;
	/**
	 * 별점
	 */
	private int rating;  // 1-5점만
	/**
	 * 가게 이름
	 */
	private String restaurantName;
	/**
	 * 
	 * @param comment 리뷰 내용
	 * @param rating 별점
	 * @param restaurantName 가게 이름
	 */
	public Review(String comment, int rating, String restaurantName) {
		this.comment = comment;
		this.rating = rating;
		this.restaurantName = restaurantName;
	}
/**
 * 
 * @return 리뷰 내용
 */
	public String getComment() {
		return comment;
	}
/**
 * 
 * @param comment 리뷰 내용
 */
	public void setComment(String comment) {
		this.comment = comment;
	}
/**
 * 
 * @return 별점
 */
	public int getRating() {
		return rating;
	}
/**
 * 
 * @return 가게 이름
 */
	public String getRestaurantName() {
		return restaurantName;
	}


}
