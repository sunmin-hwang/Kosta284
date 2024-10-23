package com.kosta.test;

import com.kosta.service.MovieMgr;
import com.kosta.vo.Movie;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr mgr = MovieMgr.getinstance();
		mgr.add(new Movie("인사이드아웃2", "외국감독", 5, "애니매이션", "최고"));
		mgr.add(new Movie("인사이드아웃3", "외쿡감독", 4, "애니매이션", "최"));
		mgr.add(new Movie("인사이드아웃4", "외꾹감독", 3, "애니매이션", "최꼬"));
		mgr.add(new Movie("원더랜드", "한국감독", 2, "SF", "흠"));
		mgr.add(new Movie("범죄도시3", "한국감독", 5, "액션", "꿀잼"));
		for(Movie movie : mgr.search()) {
			if(movie != null) System.out.println(movie);
		}
//		for(Movie movie : mgr.searchDirector("한국감독")) {
//			if(movie != null) System.out.println(movie);
//		}
//		for(Movie movie : mgr.searchGenre("애니매이션")) {
//			if(movie != null) System.out.println(movie);
//		}
		System.out.println(mgr.getSize());
		mgr.delete("원더랜드");
		for(Movie movie : mgr.search()) {
			if(movie != null) System.out.println(movie);
		}
		System.out.println(mgr.getSize());
	}
}
