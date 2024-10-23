package com.edu.oop.test;

import com.edu.oop.Movie;

public class MovieTestDrive {

	public static void main(String[] args) {
		//생성자 사용
		
//		Movie one = new Movie("Gone with the Stock", "Tragic", -2);
//		Movie two = new Movie("Lost in Cubicle Space", "Comedy", 5);
//		two.playIt();
//		Movie three = new Movie("Byte Club", "Tragic but ultimately uplifting", 127);
				
		
		//setter 사용
		Movie one = new Movie();
		Movie two = new Movie();
		Movie three = new Movie();
		
		one.setMovieField("Gone with the Stock", "Tragic", -2);
		two.setMovieField("Lost in Cubicle Space", "Comedy", 5);
		two.playIt();
		three.setMovieField("Byte Club", "Tragic but ultimately uplifting", 127);
		
		System.out.println(one.getMovie());
		System.out.println(two.getMovie());
		System.out.println(three.getMovie());
	}

}
