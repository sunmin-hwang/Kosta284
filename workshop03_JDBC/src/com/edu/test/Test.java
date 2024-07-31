package com.edu.test;

import java.sql.SQLException;
import java.util.List;

import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateIsbnException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Book;

public class Test {

	public static void main(String[] args) throws SQLException {
		BookDAO dao = BookDAO.getInstance();
		
		// 1.
		try {
			dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
		} catch (DuplicateIsbnException | DMLException e) {
			System.out.println(e.getMessage());
		}
		try {
			dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
		} catch (DuplicateIsbnException | DMLException e) {
			System.out.println(e.getMessage());
		}
		try {
			dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
		} catch (DuplicateIsbnException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===================================================================");
		
		// 2.
		try {
			printAllBooks(dao.listBooks());
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		// 3.
		try {
			System.out.println(dao.findBook("a1101"));
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		// 4.
		try {
			dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		} catch (DuplicateIsbnException | DMLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		// 5.
		try {
			dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			printAllBooks(dao.listBooks());
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		// 6.
		try {
			dao.deleteBook("a1103");
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			printAllBooks(dao.listBooks());
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		// 7.
		try {
			System.out.println(dao.count());
		} catch (RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		try {
			dao.findBookByTitle("JAVA 기").forEach(System.out::println);
			dao.findBookByTitle("JAVE").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		try {
			dao.findBookByPublisher("자앤").forEach(System.out::println);
			dao.findBookByPublisher("자엔").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		try {
			dao.findBookByAuthor("자앤 기술연구소").forEach(System.out::println);
			dao.findBookByAuthor("자앤 기술연구").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		try {
			dao.findBookByPrice(20000, 27000).forEach(System.out::println);
			dao.findBookByPrice(2500,3000).forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===================================================================");
		try {
			dao.sale("자앤 출판사", 15);
			dao.sale("자엔 출판사", 15);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dao.findBookByPublisher("자앤 출판사").forEach(System.out::println);
		} catch (DMLException | RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void printAllBooks(List<Book> list) {
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
