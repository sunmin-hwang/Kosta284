package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.servlet.vo.Book;
import web.servlet.vo.User;

public class BookDAOImpl implements BookDAO {
	private DataSource ds;
	
	private static BookDAOImpl dao = new BookDAOImpl();
	
	private BookDAOImpl() {
		//Naming Service 작업을 진행..
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
		}
	}
	public static BookDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "INSERT INTO book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description) VALUES(?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<Book> showBooks(String searchOption, String searchText) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = getConnection();
			String query = "SELECT isbn, title, catalogue, publisher, author FROM book";
			
			if(searchOption.equals("title")) {
				query += " WHERE title LIKE ?";
			} else if(searchOption.equals("publisher")) {
				query += " WHERE publisher LIKE ?";
			}
			
			ps = conn.prepareStatement(query);
			
			if(!searchOption.equals("all")) ps.setString(1, "%" + searchText+ "%");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("catalogue"), rs.getString("publisher"), rs.getString("author")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	@Override
	public Book findByTitle(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book vo = null;
		try {
			conn = getConnection();
			String query = "SELECT title, publisher, author FROM book WHERE isbn=?";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, isbn);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new Book(rs.getString("title"), rs.getString("publisher"), rs.getString("author"));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}

}
