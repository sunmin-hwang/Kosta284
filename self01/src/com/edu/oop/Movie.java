package com.edu.oop;

public class Movie {
	public String title;
	public String genre;
	public int rating;
	
	//기본 생성자
	public Movie() { }
	
	//명시적 생성자
	public Movie(String title, String genre, int rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	//setter
	public void setMovieField(String title, String genre, int rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}
	
	public void playIt() {
		System.out.println("Playing the movie");
	}
	
	public String getMovie() {
		return title + "," + genre + "," + rating;
	}
}
