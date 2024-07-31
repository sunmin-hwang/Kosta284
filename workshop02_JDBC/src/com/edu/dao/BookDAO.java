package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DMLException;
import com.edu.exception.DuplicateIsbnException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Book;

import config.ServerInfo;

public class BookDAO {
	private static BookDAO dao = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		}
	}
	
	public static BookDAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	public void close(Connection connection) throws SQLException {
		connection.close();
	}
	
	public void close(PreparedStatement statement) throws SQLException {
		statement.close();
	}
	
	public void close(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}
	
	public void insertBook(Book book) throws DuplicateIsbnException, DMLException {
		String query = "INSERT INTO book(isbn, title, author, publisher, price, description) VALUES(?,?,?,?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			
			System.out.println("[ Result OK Message ] => " + ps.executeUpdate() + " ROW INSERT OK !!");
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new DuplicateIsbnException("[ Result Error Message ] => " + book.getIsbn() + "에 해당하는 도서가 이미 존재합니다.");
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서 등록이 불가합니다.");
		}
	}


	public void updateBook(Book book) throws DMLException, RecordNotFoundException {
		String query = "UPDATE book SET title=?, author=?, publisher=?, price=?, description=? WHERE isbn=trim(?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getIsbn());
			
			if(ps.executeUpdate()==0) throw new RecordNotFoundException("[ Result Error Message ] => 해당 " +
			                                                            book.getIsbn() + "과 일치하는 도서가 존재하지 않습니다.");
			System.out.println("[ Result OK Message ] => 도서 수정 완료");
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서 수정이 불가합니다.");
		}
	}

	public void deleteBook(String isbn) throws RecordNotFoundException, DMLException {
		String query = "DELETE FROM book WHERE isbn=trim(?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, isbn);
			
			if(ps.executeUpdate()==0) throw new RecordNotFoundException("[ Result Error Message ] => 해당 " +
			                                                            isbn + "과 일치하는 도서가 존재하지 않습니다.");
			System.out.println("[ Result OK Message ] => 도서 삭제 완료");
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서 삭제가 불가합니다.");
		}
	}
	
	public Book findBook(String isbn) throws RecordNotFoundException, DMLException {
		ResultSet rs = null;
		Book book = null;
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE isbn=trim(?)";
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if(!rs.next()) throw new RecordNotFoundException("[ Result Error Message ] => 해당 " +
			                                                 isbn + "과 일치하는 도서가 존재하지 않습니다.");
			else {
				book = new Book(isbn, rs.getString("title"), rs.getString("author"),
						        rs.getString("publisher"), rs.getInt("price"), rs.getString("description"));
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		} finally {
			try {
				close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	
	public List<Book> listBooks() throws RecordNotFoundException, DMLException {
		List<Book> books = new ArrayList<Book>();
		String query = "SELECT isbn, title, author, publisher, price, description FROM book";
		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(query);
			 ResultSet rs = ps.executeQuery()){
			if(!rs.isBeforeFirst()) throw new RecordNotFoundException("[ Result Error Message ] => 현재 도서가 존재하지 않습니다.");
			else {
				while(rs.next()) {					
					books.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
							rs.getString("publisher"), rs.getInt("price"), rs.getString("description")));
				}
			}
		} catch (SQLException e) {
			throw new DMLException("[ Result Error Message ] => 문제가 발생하여 도서를 찾을 수 없습니다.");
		}
		return books;
	}
	

	public int count() throws RecordNotFoundException, DMLException {
//		int count = 0;
//		String query = "SELECT count(isbn) count FROM book";
//		try (Connection conn = getConnection();
//			 PreparedStatement ps = conn.prepareStatement(query);
//			 ResultSet rs = ps.executeQuery()){
//			if(rs.next()) count = rs.getInt("count");
//		} catch (SQLException e) {
//			throw new DMLException("문제가 발생하여 도서를 찾을 수 없습니다.");
//		}
		return listBooks().size();
	}
}
