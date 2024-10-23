package com.kosta.service;

import com.kosta.vo.Movie;

public class MovieMgr {
	private int index;
	private Movie[] movies;
	private static MovieMgr mgr = new MovieMgr();
	
	private MovieMgr() {
		movies = new Movie[5];
	}
	
	public static MovieMgr getinstance(){
		return mgr;
	}
	
	public void add(Movie movie) {
		movies[index++] = movie;
	}
	
	public Movie[] search() {
		return movies;
	}
	
	public Movie[] search(String title) {
		Movie[] titleMovies = new Movie[index];
		int tidx = 0;
		for(int i = 0 ; i < index ; i++) {
			if(movies[i].getTitle().equals(title)) titleMovies[tidx++] = movies[i];
		}
		return titleMovies;
	}
	
	public Movie[] searchDirector(String director) {
		Movie[] directorMovies = new Movie[index];
		int didx = 0;
		for(int i = 0 ; i < index ; i++) {
			if(movies[i].getDirector().equals(director)) directorMovies[didx++] = movies[i];
		}
		return directorMovies;
	}
	
	public Movie[] searchGenre(String genre) {
		Movie[] genreMovies = new Movie[index];
		int gidx = 0;
		for(int i = 0 ; i < index ; i++) {
			if(movies[i].getGenre().equals(genre)) genreMovies[gidx++] = movies[i];
		}
		return genreMovies;
	}
	
	public void delete(String title) {
		int didx = 0;
		for(int i = 0 ; i < index ; i++) {
			if(movies[i].getTitle().equals(title)) didx = i;
		}
		for(int i = didx ; i < index-1 ; i++) {
			movies[i] = movies[i+1];
		}
		movies[index-1] = null;
		index--;
	}
	
	
	public int getSize() {
		return index;
	}
}
