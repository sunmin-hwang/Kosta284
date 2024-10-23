package com.self.service;

import java.util.ArrayList;
import java.util.Collections;

import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookMgrImpl implements BookMgr{
	private ArrayList<Book> books = null;
	//싱글톤
	private static BookMgrImpl mgr = new BookMgrImpl();
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	
	@Override
	public void addBook(Book b) {
		books.add(b);
	}

	@Override
	public ArrayList<Book> getAllBook() {
		//
		return books;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = null;
		//
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				book = b;
				break;
			}
		}
		return book;
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(b.getTitle().contains(title)) temp.add(b);
		}
		return temp;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(!(b instanceof Magazine)) temp.add(b);
		}
		return temp;
	}

	@Override
	public ArrayList<Book> onlySearchMagazin() {
		ArrayList<Book> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(b instanceof Magazine) temp.add(b);
		}
		return temp;
	}

	@Override
	public ArrayList<Magazine> magazineOfThisYearInfo(int year) {
		ArrayList<Magazine> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(b instanceof Magazine) {
				if(((Magazine)b).getYear() == year) temp.add((Magazine) b);
			}
		}
		Collections.sort(temp);
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(b.getPublisher().equals(publish)) temp.add(b);
		}
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		for(Book b : books) {
			if(b.getPrice() <= price) temp.add(b);
		}
		return temp;
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		//
		for(Book b : books) {
			total += b.getPrice();
		}
		return total;
	}
	@Override
	public int getAvgPrice() {		
		//
		return mgr.getTotalPrice()/books.size();
	}
}
